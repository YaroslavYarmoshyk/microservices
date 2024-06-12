package com.microservices.core.product.service;

import com.microservices.core.product.dto.ProductDto;

public interface ProductService {
    ProductDto getProductById(final Integer productId);
}
