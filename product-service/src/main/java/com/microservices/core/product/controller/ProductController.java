package com.microservices.core.product.controller;

import com.microservices.core.product.config.annonation.ApiDefinition;
import com.microservices.core.product.dto.ProductDto;
import com.microservices.core.product.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/products")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @ApiDefinition(
            summary = "${api.get-product-by-id.summary}",
            description = "${api.get-product-by-id.description}"
    )
    @GetMapping(value = "/{productId}")
    public ProductDto getProductById(@PathVariable final Integer productId) {
        return productService.getProductById(productId);
    }
}
