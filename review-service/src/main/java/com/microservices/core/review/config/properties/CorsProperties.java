package com.microservices.core.review.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "system-configuration.cors")
public record CorsProperties(String[] allowedOrigins, String[] allowedMethods) {
}
