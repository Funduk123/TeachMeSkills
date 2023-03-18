package homework;

import homework.dto.Pair;
import homework.service.StartService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext("homework.config");

        Pair pair1 = context.getBean("pair1", Pair.class);
        Pair pair2 = context.getBean("pair2", Pair.class);
        Pair pair3 = context.getBean("pair3", Pair.class);

        List<Pair> pairs = new ArrayList<>();
        pairs.add(pair1);
        pairs.add(pair2);
        pairs.add(pair3);

        StartService service = context.getBean(StartService.class);

        service.start(pairs);

        context.close();
    }
}