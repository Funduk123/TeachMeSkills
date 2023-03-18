package homework.config;

import homework.dto.Horse;
import homework.dto.Pair;
import homework.dto.Rider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan(basePackages = {"homework"})
@EnableAspectJAutoProxy
public class AppConfig {

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
