package com.musicstore.BlueVelvet.api.service;

import com.musicstore.BlueVelvet.api.entity.Product;
import com.musicstore.BlueVelvet.api.repository.ProductRepository;
import com.musicstore.BlueVelvet.api.response.CategoryResponse;
import com.musicstore.BlueVelvet.api.response.ProductDetailResponse;
import com.musicstore.BlueVelvet.api.response.ProductDimensionResponse;
import com.musicstore.BlueVelvet.api.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository repository;

    // GET PRODUCT BY ID
    public ProductResponse getProductById(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with id: " + id));

        return mapToProductResponse(product);
    }

    // MAPPER (Entity → Response)
    private ProductResponse mapToProductResponse(Product product) {

        CategoryResponse category = null;
        if (product.getCategory() != null) {
            category = CategoryResponse.builder()
                    .id(product.getCategory().getId())
                    .name(product.getCategory().getName())
                    .build();
        }

        ProductDimensionResponse dimension = null;
        if (product.getDimension() != null) {
            dimension = ProductDimensionResponse.builder()
                    .length(product.getDimension().getLength())
                    .width(product.getDimension().getWidth())
                    .height(product.getDimension().getHeight())
                    .weight(product.getDimension().getWeight())
                    .build();
        }

        List<ProductDetailResponse> details = product.getDetails()
                .stream()
                .map(d -> ProductDetailResponse.builder()
                        .name(d.getName())
                        .value(d.getValue())
                        .build()
                )
                .toList();

        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .shortDescription(product.getShortDescription())
                .fullDescription(product.getFullDescription())
                .brand(product.getBrand())
                .list_price(product.getList_price())
                .discount(product.getDiscount())
                .isEnabled(product.isEnabled())
                .inStock(product.isInStock())
                .creationTime(product.getCreationTime())
                .updateTime(product.getUpdateTime())
                .cost(product.getCost())
                .category(category)
                .dimension(dimension)
                .details(details)
                .build();
    }

    // GET ALL PRODUCTS
    public List<ProductResponse> getAllProducts() {
        return repository.findAll()
                .stream()
              .map(this::mapToProductResponse)
                .toList();
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public static class ResourceNotFoundException extends RuntimeException {
        public ResourceNotFoundException(String message) {
            super(message);
        }
    }


    public void deleteProductById(Long id) {
        Product product = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found with id: " + id));
        repository.delete(product);
    }

}
