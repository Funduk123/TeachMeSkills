package com.tms.lecture_42;

import com.tms.lecture_42.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

@SpringBootApplication
public class Application implements CommandLineRunner {

//	@Autowired
//	private BookService service;
//
//	@Bean
//	DataSource source() {
//		return new DriverManagerDataSource();
//	}

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
//		System.out.println("Hello");
    }
}
