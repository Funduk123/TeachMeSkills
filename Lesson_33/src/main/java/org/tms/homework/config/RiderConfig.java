package org.tms.homework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tms.homework.dto.Rider;

@Configuration
public class RiderConfig {

    @Bean
    Rider rider1() {
        return new Rider("Danila");
    }

    @Bean
    Rider rider2() {
        return new Rider("Roman");
    }

    @Bean
    Rider rider3() {
        return new Rider("Sergey");
    }

}
