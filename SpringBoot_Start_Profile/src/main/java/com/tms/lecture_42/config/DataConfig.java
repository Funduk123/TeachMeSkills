package com.tms.lecture_42.config;

import com.tms.lecture_42.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@Configuration
@RequiredArgsConstructor
public class DataConfig {

    private final CarsConfig carsConfig;

    private final DSConfig dsConfig;

//    @Value("${spring.datasource.url}")
//    private String url;
//    @Value("${spring.datasource.username}")
//    private String username;
//    @Value("${spring.datasource.password}")
//    private String password;

    @Bean
    DataSource dataSource() {
        DriverManagerDataSource source = new DriverManagerDataSource();
        source.setUrl(dsConfig.getDatasource().getUrl());
        source.setUsername(dsConfig.getDatasource().getUsername());
        source.setPassword(dsConfig.getDatasource().getPassword());
        return source;
    }

    @Bean
    @ConditionalOnProperty(name = "book.service", havingValue = "true")
    BookService bookService() {
        return new BookService();
    }

}
