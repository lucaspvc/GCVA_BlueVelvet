package com.musicstore.BlueVelvet.api.request;


import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDimensionRequestDTO {
    private Float length;
    private Float width;
    private Float height;
    private Float weight;
}
