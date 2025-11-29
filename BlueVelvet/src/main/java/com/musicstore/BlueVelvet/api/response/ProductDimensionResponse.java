package com.musicstore.BlueVelvet.api.response;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDimensionResponse {
    private Float length;
    private Float width;
    private Float height;
    private Float weight;
}
