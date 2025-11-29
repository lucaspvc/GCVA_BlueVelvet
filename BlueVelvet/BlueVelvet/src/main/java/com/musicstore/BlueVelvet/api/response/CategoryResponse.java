package com.musicstore.BlueVelvet.api.response;

import com.musicstore.BlueVelvet.api.entity.Category;
import lombok.Builder;
import lombok.Data;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
public class CategoryResponse {
    private Long id;
    private String name;
    private String image;
    private boolean enabled;
    private Long parentId;
    private List<CategoryResponse> children;

    // Método auxiliar para converter Entity -> DTO (pode ir num Mapper separado)
    public static CategoryResponse fromEntity(Category category) {
        return CategoryResponse.builder()
                .id(category.getId())
                .name(category.getName())
                .image(category.getImage())
                .enabled(category.isEnabled())
                .parentId(category.getParent() != null ? category.getParent().getId() : null)
                .children(category.getChildren().stream()
                        .map(CategoryResponse::fromEntity)
                        .collect(Collectors.toList()))
                .build();
    }
}