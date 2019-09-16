package com.webapplication.discounthero.service;

import com.webapplication.discounthero.domain.AmazonBaseline;
import com.webapplication.discounthero.domain.AmazonBaselineCategory;
import com.webapplication.discounthero.dto.AmazonBookDto;
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
public class AmazonBookService {

    @Autowired
    private AmazonBaselineRepository amazonBaselineRepository;
    @Autowired
    private AmazonBaselineCategoryRepository amazonBaselineCategoryRepository;

    public List<AmazonBookDto> getAllItems() {
        Set<String> bookCategoryIds = amazonBaselineCategoryRepository.findAllByCategory("Books")
                .stream()
                .map(AmazonBaselineCategory::getItemId)
                .collect(Collectors.toSet());
        List<AmazonBaseline> allItems = amazonBaselineRepository.findAll();
        return allItems.stream()
                .filter(item -> bookCategoryIds.contains(item.getId()))
                .map(amazonBook -> {
                    AmazonBookDto dto = new AmazonBookDto();
                    BeanUtils.copyProperties(amazonBook, dto);
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