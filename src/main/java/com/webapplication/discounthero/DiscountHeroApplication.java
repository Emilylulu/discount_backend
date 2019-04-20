package com.webapplication.discounthero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class DiscountHeroApplication {

    public static void main(String[] args) {
        SpringApplication.run(DiscountHeroApplication.class, args);
    }

}
