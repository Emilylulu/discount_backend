package com.webapplication.discounthero.domain;

import lombok.Data;
import lombok.Getter;
import org.hibernate.annotations.Cache;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import static org.hibernate.annotations.CacheConcurrencyStrategy.NONSTRICT_READ_WRITE;

@Entity
@Table(name = "baseline_amazon_categories")
@Data
@Getter
@Cache(usage = NONSTRICT_READ_WRITE)
public class AmazonBaselineCategory {
    @Id
    @Column(name = "asin", length = 11)
    private String itemId;

    @Column(name = "categories", length = 60)
    private String category;
}
