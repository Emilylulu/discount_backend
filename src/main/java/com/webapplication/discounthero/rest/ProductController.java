package com.webapplication.discounthero.rest;

import com.webapplication.discounthero.dto.AmazonClothDto;
import com.webapplication.discounthero.service.AmazonClothService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/product")
public class ProductController {

    private AmazonClothService amazonClothService;

    public ProductController(AmazonClothService amazonClothService) {
        this.amazonClothService = amazonClothService;
    }
    @GetMapping(path = "/all")
    public List<AmazonClothDto> getAllItems() {
        return amazonClothService.getAllItems();
    }
}
