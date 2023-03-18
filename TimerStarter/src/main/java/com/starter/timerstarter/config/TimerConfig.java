package com.starter.timerstarter.config;

import com.starter.timerstarter.service.TimerService;
import com.starter.timerstarter.service.impl.TimerServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class TimerConfig {

    @Bean
    TimerService service() {
        return new TimerServiceImpl();
    }

}
