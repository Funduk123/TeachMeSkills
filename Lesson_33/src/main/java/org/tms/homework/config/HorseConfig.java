package org.tms.homework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tms.homework.dto.Horse;

@Configuration
public class HorseConfig {

    @Bean
    Horse horse1() {
        return new Horse(1);
    }

    @Bean
    Horse horse2() {
        return new Horse(2);
    }

    @Bean
    Horse horse3() {
        return new Horse(3);
    }
}
