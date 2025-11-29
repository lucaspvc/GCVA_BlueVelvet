package com.musicstore.BlueVelvet.api.controller;

import com.musicstore.BlueVelvet.api.request.CategoryRequest;
import com.musicstore.BlueVelvet.api.response.CategoryResponse;
import com.musicstore.BlueVelvet.api.service.CategoryService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Log4j2
@RestController
@RequestMapping("/category")
public class CategoryController {

    private final CategoryService categoryService;

    // US-0907: Listar categorias (paginado, apenas raízes, 5 por página padrão)
    @GetMapping
    @Operation(summary = "List all   categories", description = "Fetch top-level categories with pagination (default 5 per page). Sub-categories are nested in the response.")
    public ResponseEntity<Page<CategoryResponse>> getAllCategories(
            @PageableDefault(page = 0, size = 5, sort = "name", direction = Sort.Direction.ASC) Pageable pageable
    ) {
        log.info("Request received to fetch categories with pagination: {}", pageable);
        Page<CategoryResponse> response = categoryService.getAllRootCategories(pageable);
        return ResponseEntity.ok(response);
    }

    // US-2100: Obter detalhes de uma categoria (incluindo filhos para o breadcrumb/menu)
    @GetMapping("/{id}")
    @Operation(summary = "Get category by id", description = "Get a category details including its children")
    public ResponseEntity<CategoryResponse> getCategoryById(@PathVariable Long id) {
        log.info("Request received to fetch category by id: {}", id);
        return ResponseEntity.ok(categoryService.getCategoryById(id));
    }

    // US-1306: Criar Categoria
    @PostMapping
    @Operation(summary = "Create a new category", description = "Create a category (Root or Sub-category based on parentId)")
    public ResponseEntity<CategoryResponse> createCategory(@RequestBody CategoryRequest request) {
        log.info("Request received to create a new category: {}", request);
        CategoryResponse response = categoryService.createCategory(request);
        return ResponseEntity.ok(response);
    }

    // US-1307: Editar Categoria
    @PutMapping("/{id}")
    @Operation(summary = "Update category", description = "Update an existing category info or hierarchy")
    public ResponseEntity<CategoryResponse> updateCategory(@PathVariable Long id, @RequestBody CategoryRequest request) {
        log.info("Request received to update category id: {} with data: {}", id, request);
        CategoryResponse response = categoryService.updateCategory(id, request);
        return ResponseEntity.ok(response);
    }

    // Delete (Regra: só se não tiver filhos)
    @DeleteMapping("/{id}")
    @Operation(summary = "Delete category", description = "Delete a category by ID (only if it has no children)")
    public ResponseEntity<Void> deleteCategory(@PathVariable Long id) {
        log.info("Request received to delete category id: {}", id);
        categoryService.deleteCategory(id);
        return ResponseEntity.noContent().build();
    }
}