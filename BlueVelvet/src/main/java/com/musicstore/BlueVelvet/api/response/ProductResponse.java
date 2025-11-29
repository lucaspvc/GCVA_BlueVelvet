package com.musicstore.BlueVelvet.api.response;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    private Long id;
    //UID
    private String name;
    private String shortDescription;
    private String fullDescription;
    private String brand;
    private CategoryResponse category;
    private BigDecimal list_price;
    private BigDecimal discount;
    private Boolean isEnabled;
    private Boolean inStock;
    private LocalDateTime creationTime;
    private LocalDateTime updateTime;
    private ProductDimensionResponse dimension;
    private BigDecimal cost;
    private List<ProductDetailResponse> details;
}
