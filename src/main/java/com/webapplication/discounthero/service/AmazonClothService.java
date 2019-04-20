package com.webapplication.discounthero.service;

import com.webapplication.discounthero.domain.AmazonCloth;
import com.webapplication.discounthero.dto.AmazonClothDto;
import com.webapplication.discounthero.repository.AmazonClothRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class AmazonClothService {

    @Autowired
    private AmazonClothRepository amazonClothRepository;

    public List<AmazonClothDto> getAllItems() {
        List<AmazonCloth> allItems = amazonClothRepository.findAll();
        return allItems.stream()
                .map(amazonCloth -> AmazonClothDto.builder()
                        .title(amazonCloth.getTitle())
                        .imgUrl(amazonCloth.getImgUrl())
                        .price(amazonCloth.getPrice())
                        .build())
                .collect(Collectors.toList());
    }
}
