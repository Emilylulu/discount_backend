package com.webapplication.discounthero.rest;


import com.webapplication.discounthero.dto.AmazonToyDto;
import com.webapplication.discounthero.dto.ProductDetailDto;
import com.webapplication.discounthero.service.AmazonToyService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/toy")
public class ToyController {
    private AmazonToyService amazonToyService;

    public ToyController(AmazonToyService amazonToyService) {
        this.amazonToyService = amazonToyService;
    }
    @GetMapping(path = "/all")
    public List<AmazonToyDto> getAllItems() {
        return amazonToyService.getAllItems();
    }
    @GetMapping(path = "/user/{id}")
    public ProductDetailDto getOneItem(@PathVariable("id") String id) {
        return amazonToyService.getOneItem(id);
    }
}
