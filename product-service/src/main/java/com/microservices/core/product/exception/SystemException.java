package com.microservices.core.product.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class SystemException extends RuntimeException {
    private final String message;
    private final HttpStatus status;

    public SystemException(final String message, final HttpStatus status) {
        super(message);
        this.message = message;
        this.status = status;
    }
}
