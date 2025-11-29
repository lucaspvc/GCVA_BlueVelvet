package com.musicstore.BlueVelvet.api.request;

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
public class ProductRequest {
    private String name;
    private String shorDescription;
    private String fullDescription;
    private String brand;
    private Long categoryId;
    private BigDecimal listPrice;
    private BigDecimal discount;
    private Boolean isEnabled;
    private Boolean inStock;
    private LocalDateTime creationTime;
    private LocalDateTime updateTime;
    private ProductDimensionRequestDTO dimensionRequest;
    private BigDecimal cost;
    private List<ProductDetailRequestDTO> details;

}
