package com.musicstore.BlueVelvet.api.request;

import lombok.Data;

@Data
public class CategoryRequest {
    private String name;
    private String image;
    private Boolean enabled;
    private Long parentId;
}