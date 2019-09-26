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
@Table(name = "baseline_reviews")
@Data
@Getter
@Cache(usage = NONSTRICT_READ_WRITE)
public class AmazonBaselineReview {
    @Id
    @Column(name = "reviewerid")
    private String reviewerID;

    @Column(name = "asin", length = 11)
    private String itemId;


    @Column(name = "reviewtext", length = 60)
    private String reviewText;

    @Column(name = "reviewername")
    private String reviewerName;

    @Column(name = "reviewtime")
    private String reviewTime;

    @Column(name = "overall")
    private int rating;
}
