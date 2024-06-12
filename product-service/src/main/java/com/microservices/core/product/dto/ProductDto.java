package com.microservices.core.product.dto;

public record ProductDto(
        Integer productId,
        String name,
        Integer weight
) {
}
