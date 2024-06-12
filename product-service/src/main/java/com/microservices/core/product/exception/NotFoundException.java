package com.microservices.core.product.exception;

import lombok.Getter;

@Getter
public class NotFoundException extends RuntimeException {
    private final String message;

    public NotFoundException(final String message) {
        super(message);
        this.message = message;
    }
}
