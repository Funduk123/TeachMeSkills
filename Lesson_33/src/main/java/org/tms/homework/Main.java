package org.tms.homework;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.tms.homework.dto.Pair;
import org.tms.homework.service.HorseRacingService;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext("org.tms");

        Pair pair1 = context.getBean("pair1", Pair.class);
        Pair pair2 = context.getBean("pair2", Pair.class);
        Pair pair3 = context.getBean("pair3", Pair.class);

        List<Pair> pairs = new ArrayList<>();
        pairs.add(pair1);
        pairs.add(pair2);
        pairs.add(pair3);

        HorseRacingService service = context.getBean(HorseRacingService.class);

        service.start(pairs);

        context.close();
    }
}
