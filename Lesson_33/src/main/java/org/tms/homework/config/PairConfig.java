package org.tms.homework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.tms.homework.dto.Horse;
import org.tms.homework.dto.Pair;
import org.tms.homework.dto.Rider;

@Configuration
public class PairConfig {

    @Bean
    Pair pair1(Horse horse1, Rider rider1) {
        return new Pair(horse1, rider1);
    }

    @Bean
    Pair pair2(Horse horse2, Rider rider2) {
        return new Pair(horse2, rider2);
    }

    @Bean
    Pair pair3(Horse horse3, Rider rider3) {
        return new Pair(horse3, rider3);
    }

}
