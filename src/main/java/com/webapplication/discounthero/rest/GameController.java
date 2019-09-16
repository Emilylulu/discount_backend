package com.webapplication.discounthero.rest;

import com.webapplication.discounthero.dto.AmazonGameDto;
import com.webapplication.discounthero.dto.ProductDetailDto;
import com.webapplication.discounthero.service.AmazonGameService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping(path = "/game")
public class GameController {
    private AmazonGameService amazonGameService;

    public GameController(AmazonGameService amazonGameService) {
        this.amazonGameService = amazonGameService;
    }
    @GetMapping(path = "/all")
    public List<AmazonGameDto> getAllItems() {
        return amazonGameService.getAllItems();
    }
    @GetMapping(path = "/user/{id}")
    public ProductDetailDto getOneItem(@PathVariable("id") String id) {
        return amazonGameService.getOneItem(id);
    }
}
