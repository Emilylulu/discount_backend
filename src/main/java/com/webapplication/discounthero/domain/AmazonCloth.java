package com.webapplication.discounthero.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Table(name = "amazon_cloth")
@Entity(name = "amazon_cloth")
public class AmazonCloth {
    @Id
    @Column(name = "asin")
    private String id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "imurl")
    private String imgUrl;

    @Column(name = "price")
    private String price;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;
}
