package com.tms.orderservice.config;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi registerGroup() {
        return GroupedOpenApi.builder()
                .group("REGISTER GROUP")
                .pathsToMatch("/register/**", "/register")
                .build();
    }

    @Bean
    public GroupedOpenApi storeGroup() {
        return GroupedOpenApi.builder()
                .group("STORE GROUP")
                .pathsToMatch("/store/**", "/store")
                .build();
    }

}
