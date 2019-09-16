package com.webapplication.discounthero.rest;

import com.webapplication.discounthero.dto.AmazonPurseDto;
import com.webapplication.discounthero.dto.ProductDetailDto;
import com.webapplication.discounthero.service.AmazonPurseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/purse")
public class PurseController {
    private AmazonPurseService amazonPurseService;

    public PurseController(AmazonPurseService amazonPurseService) {
        this.amazonPurseService = amazonPurseService;
    }
    @GetMapping(path = "/all")
    public List<AmazonPurseDto> getAllItems() {
        return amazonPurseService.getAllItems();
    }
    @GetMapping(path = "/user/{id}")
    public ProductDetailDto getOneItem(@PathVariable("id") String id) {
        return amazonPurseService.getOneItem(id);
    }
}
