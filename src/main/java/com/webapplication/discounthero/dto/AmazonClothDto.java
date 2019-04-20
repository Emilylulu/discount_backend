package com.webapplication.discounthero.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AmazonClothDto {
    private String price;
    private String title;
    private String imgUrl;
}
