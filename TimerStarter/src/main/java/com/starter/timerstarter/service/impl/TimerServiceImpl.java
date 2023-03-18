package com.starter.timerstarter.service.impl;

import com.starter.timerstarter.service.TimerService;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.TimeUnit;

public class TimerServiceImpl implements TimerService {


    @Override
    @Scheduled(fixedDelay = 3, timeUnit = TimeUnit.SECONDS)
    public void timerStart() {
        System.out.println("TUK");
    }

}
