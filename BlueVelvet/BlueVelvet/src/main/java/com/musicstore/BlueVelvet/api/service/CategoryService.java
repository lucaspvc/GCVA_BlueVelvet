package com.musicstore.BlueVelvet.api.service;

import com.musicstore.BlueVelvet.api.entity.Category;
import com.musicstore.BlueVelvet.api.repository.CategoryRepository;
import com.musicstore.BlueVelvet.api.request.CategoryRequest;
import com.musicstore.BlueVelvet.api.response.CategoryResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    // US-1306: Create
    @Transactional
    public CategoryResponse createCategory(CategoryRequest request) {
        if (categoryRepository.existsByName(request.getName())) {
            throw new IllegalArgumentException("Category name must be unique");
        }

        Category category = new Category();
        category.setName(request.getName());
        category.setImage(request.getImage());
        category.setEnabled(request.getEnabled() != null ? request.getEnabled() : true);

        // Lógica do Pai/Filho
        if (request.getParentId() != null) {
            Category parent = categoryRepository.findById(request.getParentId())
                    .orElseThrow(() -> new RuntimeException("Parent category not found"));
            category.setParent(parent);
        }

        Category saved = categoryRepository.save(category);
        return CategoryResponse.fromEntity(saved);
    }

    // US-1307: Update (O método que faltava)
    @Transactional
    public CategoryResponse updateCategory(Long id, CategoryRequest request) {
        // 1. Busca a categoria existente
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found with id: " + id));

        // 2. Validação de Nome Único (apenas se o nome mudou)
        if (!category.getName().equals(request.getName()) && categoryRepository.existsByName(request.getName())) {
            throw new IllegalArgumentException("Category name already exists");
        }

        // Atualiza campos básicos
        category.setName(request.getName());

        // Regra da Imagem (US-1307): Só atualiza se vier preenchido
        // Se o usuário mandou null ou string vazia, mantemos a imagem antiga
        if (request.getImage() != null && !request.getImage().isBlank()) {
            // TODO: Aqui entraria a lógica de deletar a imagem antiga do disco/S3
            category.setImage(request.getImage());
        }

        if (request.getEnabled() != null) {
            category.setEnabled(request.getEnabled());
        }

        // 3. Atualização de Parente (Hierarquia)
        if (request.getParentId() != null) {
            // Validação crítica: Uma categoria não pode ser pai de si mesma
            if (request.getParentId().equals(id)) {
                throw new IllegalArgumentException("A category cannot be its own parent.");
            }

            Category parent = categoryRepository.findById(request.getParentId())
                    .orElseThrow(() -> new RuntimeException("Parent category not found"));
            category.setParent(parent);
        } else {
            // Se vier nulo no request, ela vira uma categoria Raiz (Root)
            category.setParent(null);
        }

        return CategoryResponse.fromEntity(categoryRepository.save(category));
    }

    // US-0907: Listar apenas raízes paginadas
    public Page<CategoryResponse> getAllRootCategories(Pageable pageable) {
        return categoryRepository.findAllByParentIsNull(pageable)
                .map(CategoryResponse::fromEntity);
    }

    // US-Delete: Regra de não deletar se tiver filhos
    public void deleteCategory(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));

        if (!category.getChildren().isEmpty()) {
            throw new RuntimeException("Cannot delete category with children. Delete sub-categories first.");
        }

        // TODO: Adicionar lógica para deletar a imagem do sistema de arquivos aqui

        categoryRepository.delete(category);
    }

    // Método auxiliar para buscar por ID
    public CategoryResponse getCategoryById(Long id) {
        Category category = categoryRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Category not found"));
        return CategoryResponse.fromEntity(category);
    }
}