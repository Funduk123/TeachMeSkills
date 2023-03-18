package patterns.structural.decorator;

import patterns.structural.decorator.service.ReadService;
import patterns.structural.decorator.service.BufferedReadService;
import patterns.structural.decorator.service.LogReadService;
import patterns.structural.decorator.service.SimpleReadService;

public class Main {

    public static void main(String[] args) {

        ReadService readService = new LogReadService(new BufferedReadService(new SimpleReadService()));

        for (int i = 0; i < 25; i++) {
            System.out.println(readService.read());
        }

    }
}
