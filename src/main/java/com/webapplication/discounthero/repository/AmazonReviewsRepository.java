package com.webapplication.discounthero.repository;

import com.webapplication.discounthero.domain.AmazonBaselineReview;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Set;


public interface AmazonReviewsRepository extends JpaRepository<AmazonBaselineReview, String>{
    Set<AmazonBaselineReview> findAllByItemId(String itemId);

}
