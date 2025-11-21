package com.musicstore.BlueVelvet.api.resquest;

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
    private String category;
    private BigDecimal listPrice;
    private BigDecimal discout;
    private Boolean isEnabled;
    private Boolean inStock;
    private LocalDateTime creationTime;
    private LocalDateTime updateTime;
    private ProductDimensionRequest dimensionRequest;
    private BigDecimal cost;
    private List<ProductDetailRequest> details;

}
