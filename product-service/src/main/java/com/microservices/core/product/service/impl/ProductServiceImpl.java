package com.microservices.core.product.service.impl;

import com.microservices.core.product.dto.ProductDto;
import com.microservices.core.product.service.ProductService;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Override
    public ProductDto getProductById(final Integer productId) {
        return new ProductDto(productId, "name-" + productId, 123);
    }
}
