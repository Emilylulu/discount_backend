package com.webapplication.discounthero.service;

import com.webapplication.discounthero.domain.AmazonBaseline;
import com.webapplication.discounthero.domain.AmazonBaselineCategory;
import com.webapplication.discounthero.domain.AmazonBaselineReview;
import com.webapplication.discounthero.dto.AmazonClothDto;
import com.webapplication.discounthero.dto.ProductDetailDto;
import com.webapplication.discounthero.dto.ProductReviewDto;
import com.webapplication.discounthero.exception.ItemNotFoundException;
import com.webapplication.discounthero.repository.AmazonBaselineCategoryRepository;
import com.webapplication.discounthero.repository.AmazonBaselineRepository;
import com.webapplication.discounthero.repository.AmazonReviewsRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class AmazonClothService {

    @Autowired
    private AmazonBaselineRepository amazonBaselineRepository;

    @Autowired
    private AmazonBaselineCategoryRepository amazonBaselineCategoryRepository;

    @Autowired
    private AmazonReviewsRepository amazonReviewsRepository;

    public List<AmazonClothDto> getAllItems() {
        Set<String> clothCategoryIds = amazonBaselineCategoryRepository.findAllByCategory("Clothing")
                .stream()
                .map(AmazonBaselineCategory::getItemId)
                .collect(Collectors.toSet());
        List<AmazonBaseline> allItems = amazonBaselineRepository.findAll();
        return allItems.stream()
                .filter(item -> clothCategoryIds.contains(item.getId()))
                .map(amazonCloth -> {
                    AmazonClothDto dto = new AmazonClothDto();
                    BeanUtils.copyProperties(amazonCloth, dto);
                    return dto;
                })
                .collect(Collectors.toList());
    }

    public ProductDetailDto getOneItem(String id) {

        AmazonBaseline oneItem = amazonBaselineRepository.findById(id)
                .orElseThrow(() -> new ItemNotFoundException(id));
        ProductDetailDto dto = new ProductDetailDto();
        BeanUtils.copyProperties(oneItem, dto);
        return dto;


        }

    public List<ProductReviewDto> getReview(String id) {
        Set<String> allReviews = amazonReviewsRepository.findAllByItemId(id)
                .stream()
                .map(AmazonBaselineReview::getItemId)
                .collect(Collectors.toSet());
//        for (String list : allReviews) {
//            System.out.println(list + "********");
//
//        }
        List<AmazonBaselineReview> reviews = amazonReviewsRepository.findAll();
        return reviews.stream()
                .filter(review -> allReviews.contains(review.getItemId()))
                .map(amazonReview -> {
                    ProductReviewDto dto = new ProductReviewDto();
                    BeanUtils.copyProperties(amazonReview, dto);
                    return dto;
                })
                .collect(Collectors.toList());

    }
    }


