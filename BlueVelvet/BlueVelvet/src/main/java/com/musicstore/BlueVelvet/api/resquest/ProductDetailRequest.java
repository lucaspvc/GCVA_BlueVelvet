package com.musicstore.BlueVelvet.api.resquest;

import lombok.*;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetailRequest {
    private String name;
    private String value;

}
