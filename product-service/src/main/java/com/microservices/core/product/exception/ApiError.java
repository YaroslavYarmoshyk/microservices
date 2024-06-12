package com.microservices.core.product.exception;

import org.springframework.http.HttpStatus;

import java.time.ZonedDateTime;
import java.util.Collection;

import static com.microservices.core.product.utils.DateTimeUtils.DEFAULT_ZONE_ID;

public record ApiError(
        ZonedDateTime timestamp,
        HttpStatus httpStatus,
        String path,
        Collection<String> errors
) {
    public ApiError(final HttpStatus httpStatus, final String path, final Collection<String> errors) {
        this(ZonedDateTime.now(DEFAULT_ZONE_ID), httpStatus, path, errors);
    }
}