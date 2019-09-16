package com.webapplication.discounthero.service;

import com.webapplication.discounthero.domain.AmazonBaseline;
import com.webapplication.discounthero.domain.AmazonBaselineCategory;
import com.webapplication.discounthero.dto.AmazonJewelryDto;
import com.webapplication.discounthero.dto.ProductDetailDto;
import com.webapplication.discounthero.repository.AmazonBaselineCategoryRepository;
import com.webapplication.discounthero.repository.AmazonBaselineRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class AmazonJewelryService {
    @Autowired
    private AmazonBaselineRepository amazonBaselineRepository;
    @Autowired
    private AmazonBaselineCategoryRepository amazonBaselineCategoryRepository;

    public List<AmazonJewelryDto> getAllItems() {
        Set<String> jewCategoryIds = amazonBaselineCategoryRepository.findAllByCategory("Jewelry")
                .stream()
                .map(AmazonBaselineCategory::getItemId)
                .collect(Collectors.toSet());

        List<AmazonBaseline> allItems = amazonBaselineRepository.findAll();
        return allItems.stream()
                .filter(item -> jewCategoryIds.contains(item.getId()))
                .map(amazonJewelry -> {
                    AmazonJewelryDto dto = new AmazonJewelryDto();
                    BeanUtils.copyProperties(amazonJewelry, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }
    public ProductDetailDto getOneItem(String id) {

        AmazonBaseline oneItem = amazonBaselineRepository.findById(id).get();
        ProductDetailDto dto = new ProductDetailDto();
        BeanUtils.copyProperties(oneItem, dto);
        return dto;
    }
}
