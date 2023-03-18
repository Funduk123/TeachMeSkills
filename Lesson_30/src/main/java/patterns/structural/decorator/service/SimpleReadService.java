package patterns.structural.decorator.service;

import java.util.Random;

public class SimpleReadService implements ReadService {
    @Override
    public int read() {
        int i = new Random().nextInt();
        System.out.println("Return from random int = " + i);
        return i;
    }
}
