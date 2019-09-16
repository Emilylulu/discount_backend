package com.webapplication.discounthero.rest;

import com.webapplication.discounthero.dto.AmazonJewelryDto;
import com.webapplication.discounthero.dto.ProductDetailDto;
import com.webapplication.discounthero.service.AmazonJewelryService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/jewelry")
public class JewelryController {
    private AmazonJewelryService amazonJewelryService;

    public JewelryController(AmazonJewelryService amazonJewelryService) {
        this.amazonJewelryService = amazonJewelryService;
    }
    @GetMapping(path = "/all")
    public List<AmazonJewelryDto> getAllItems() {
        return amazonJewelryService.getAllItems();
    }
    @GetMapping(path = "/user/{id}")
    public ProductDetailDto getOneItem(@PathVariable("id") String id) {
        return amazonJewelryService.getOneItem(id);
    }
}
