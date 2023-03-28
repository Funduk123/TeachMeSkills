package com.tms.rest4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
@SpringBootApplication
@EnableFeignClients(basePackages = "com.tms")
public class Application_3 {
    public static void main(String[] args) {
        SpringApplication.run(Application_3.class, args);
    }

}
