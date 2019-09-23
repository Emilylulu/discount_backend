package com.webapplication.discounthero.rest;

import com.webapplication.discounthero.dto.AmazonClothDto;
import com.webapplication.discounthero.dto.ProductDetailDto;
import com.webapplication.discounthero.service.AmazonClothService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/cloth")
//@RequestMapping(path = "/user")
public class ClothController {
    private AmazonClothService amazonClothService;

    public ClothController(AmazonClothService amazonClothService) {
        this.amazonClothService = amazonClothService;
    }
    @GetMapping(path = "/all")
    public List<AmazonClothDto> getAllItems() {
        return amazonClothService.getAllItems();
    }
    @GetMapping(path = "/user/{id}")
    public ProductDetailDto getOneItem(@PathVariable("id") String id) {
        return amazonClothService.getOneItem(id);
    }
}
