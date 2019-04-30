package com.webapplication.discounthero.service;

import com.webapplication.discounthero.domain.AmazonCloth;
import com.webapplication.discounthero.dto.AmazonClothDto;
import com.webapplication.discounthero.dto.ProductDetailDto;
import com.webapplication.discounthero.repository.AmazonClothRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class AmazonClothService {

    @Autowired
    private AmazonClothRepository amazonClothRepository;

    public List<AmazonClothDto> getAllItems() {
        List<AmazonCloth> allItems = amazonClothRepository.findAll();
        return allItems.stream()
                .map(amazonCloth -> {
                    AmazonClothDto dto = new AmazonClothDto();
                    BeanUtils.copyProperties(amazonCloth, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public ProductDetailDto getOneItem(String id) {

        AmazonCloth oneItem = amazonClothRepository.findById(id).get();
        ProductDetailDto dto = new ProductDetailDto();
        BeanUtils.copyProperties(oneItem, dto);
        return dto;


        }
    }


