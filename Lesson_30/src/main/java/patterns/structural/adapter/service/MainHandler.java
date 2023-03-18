package patterns.structural.adapter.service;

import java.util.Date;

public class MainHandler {

    ClientService clientService;

    public MainHandler(ClientService clientService) {
        this.clientService = clientService;
    }

    public void save(String login, String password, Date birthday) {
        clientService.save(login, password, birthday);
    }

}
