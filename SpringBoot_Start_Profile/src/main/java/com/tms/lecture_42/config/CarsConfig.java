package com.tms.lecture_42.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

@Configuration
@ConfigurationProperties(prefix = "car")
@Getter
@Setter
public class CarsConfig {

    private Map<String, CarType> types;

    @Getter
    @Setter
    public static class CarType {
        private String name;
        private Integer age;
        private Color color;
    }

    public enum Color {
        BLACK,
        RED,
        WHITE
    }

}
