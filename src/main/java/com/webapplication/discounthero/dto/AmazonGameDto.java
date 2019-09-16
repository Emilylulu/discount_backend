package com.webapplication.discounthero.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AmazonGameDto {
    private String price;
    private String title;
    private String imgUrl;
    private String id;
}
