package com.musicstore.BlueVelvet.api.request;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailRequestDTO {
    private String name;
    private String value;
}
