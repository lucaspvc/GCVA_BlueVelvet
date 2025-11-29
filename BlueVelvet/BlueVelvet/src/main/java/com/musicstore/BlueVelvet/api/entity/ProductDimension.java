package com.musicstore.BlueVelvet.api.entity;

import jakarta.persistence.Embeddable;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class ProductDimension {

    private Float length;
    private Float width;
    private Float height;
    private Float weight;
}
