package com.microservices.core.product.controller;

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

    @GetMapping(value = "/{productId}")
    public ProductDto getProductById(@PathVariable final Integer productId) {
        return productService.getProductById(productId);
    }
}
