package com.microservices.core.review.config;

import com.microservices.core.review.config.properties.CorsProperties;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.config.CorsRegistry;
import org.springframework.web.reactive.config.WebFluxConfigurer;

@Configuration
@RequiredArgsConstructor
public class SecurityConfig {
    private final CorsProperties corsProperties;

    @Bean
    public WebFluxConfigurer corsConfigurer() {
        return new WebFluxConfigurer() {
            @Override
            public void addCorsMappings(final CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowCredentials(true)
                        .allowedHeaders("*")
                        .allowedMethods(corsProperties.allowedMethods())
                        .allowedOrigins(corsProperties.allowedOrigins());
            }
        };
    }
}
