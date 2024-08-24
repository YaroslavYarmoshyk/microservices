package com.microservices.core.review.controller;

import com.microservices.core.review.config.annonation.ApiDefinition;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/reviews")
public class ReviewController {

    @ApiDefinition(
            summary = "${api.get-reviews-by-product-id.summary}",
            description = "${api.get-reviews-by-product-id.description}"
    )
    @GetMapping
    public String getReview(final @RequestParam("product-id") Integer productId) {
        return "Some review for product: " + productId;
    }
}
