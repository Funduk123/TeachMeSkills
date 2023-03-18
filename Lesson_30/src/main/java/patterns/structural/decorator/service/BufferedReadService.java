package patterns.structural.decorator.service;

import java.util.ArrayList;
import java.util.List;

public class BufferedReadService implements ReadService {

    private ReadService readService;

    List<Integer> buffer = new ArrayList<>();

    public BufferedReadService(ReadService readService) {
        this.readService = readService;
    }

    @Override
    public int read() {

        if (buffer.isEmpty()) {
            System.out.println("Buffer is empty");
            for (int i = 0; i < 10; i++) {
                int read = readService.read();
                buffer.add(read);
            }
        }
        System.out.println("Return from buffer");
        return buffer.remove(0);
    }
}
