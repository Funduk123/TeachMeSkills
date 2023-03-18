package patterns.structural.adapter;

import patterns.structural.adapter.service.MainHandler;
import patterns.structural.adapter.service.AdapterClientServiceImpl;

public class Main {
    public static void main(String[] args) {

        MainHandler mainHandler = new MainHandler(new AdapterClientServiceImpl());
        mainHandler.save("Danila", "12345", null);

    }
}
