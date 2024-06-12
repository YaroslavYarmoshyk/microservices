package com.microservices.core.product.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.bind.support.WebExchangeBindException;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Slf4j
@RestControllerAdvice
public class GlobalControllerExceptionHandler {

    @ExceptionHandler(value = WebExchangeBindException.class)
    protected ResponseEntity<ApiError> handleWebExchangeBindException(final WebExchangeBindException ex, final ServerHttpRequest request) {
        final List<String> errors = ex.getBindingResult().getAllErrors().stream()
                .map(this::getErrorMessage)
                .toList();
        final ApiError apiError = getApiError(HttpStatus.BAD_REQUEST, request.getPath().value(), errors);
        log.info(ex.getClass().getSimpleName(), ex);
        return new ResponseEntity<>(apiError, HttpStatusCode.valueOf(apiError.httpStatus().value()));
    }

    @ExceptionHandler(value = SystemException.class)
    protected ResponseEntity<ApiError> handleSystemException(final SystemException ex, final ServerHttpRequest request) {
        final ApiError apiError = getApiError(ex.getStatus(), request.getPath().value(), ex.getMessage());
        log.info(ex.getClass().getSimpleName(), ex);
        return new ResponseEntity<>(apiError, HttpStatusCode.valueOf(apiError.httpStatus().value()));
    }

    @ExceptionHandler(value = NotFoundException.class)
    protected ResponseEntity<ApiError> handleNotFoundException(final NotFoundException ex, final ServerHttpRequest request) {
        final ApiError apiError = getApiError(HttpStatus.NOT_FOUND, request.getPath().value(), ex.getMessage());
        log.info(ex.getClass().getSimpleName(), ex);
        return new ResponseEntity<>(apiError, HttpStatusCode.valueOf(apiError.httpStatus().value()));
    }

    private static ApiError getApiError(final HttpStatus status, final String path, final String error) {
        return getApiError(status, path, Collections.singleton(error));
    }

    private static ApiError getApiError(final HttpStatus status, final String path, final Collection<String> errors) {
        return new ApiError(status, path, errors);
    }

    private String getErrorMessage(ObjectError e) {
        if (e instanceof FieldError fieldError) {
            String field = fieldError.getField();
            String message = e.getDefaultMessage();
            return field + " " + message;
        }
        return e.getDefaultMessage();
    }
}
