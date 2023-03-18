package patterns.structural.decorator.service;

public class LogReadService implements ReadService {

    private ReadService readService;

    public LogReadService(ReadService readService) {
        this.readService = readService;
    }

    @Override
    public int read() {
        long start = System.currentTimeMillis();
        int read = readService.read();
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        long end = System.currentTimeMillis();
        System.out.println("read time as " + (end - start));
        return read;
    }
}
