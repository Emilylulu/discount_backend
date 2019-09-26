package com.webapplication.discounthero.dto;

import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;
@Data
@NoArgsConstructor
public class ProductReviewDto {
    private String itemId;
    private String reviewerID;
    private String reviewText;
    private String reviewerName;
    private String reviewTime;
}
