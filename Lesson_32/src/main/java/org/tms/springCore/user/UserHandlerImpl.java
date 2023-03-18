package org.tms.springCore.user;

import org.tms.springCore.message.Messenger;

public class UserHandlerImpl implements UserHandler {

    private UserService service;
    private Messenger messenger;

    public UserHandlerImpl(UserService service, Messenger messenger) {
        System.out.println("Constructor");
        this.service = service;
        this.messenger = messenger;
    }

    public void setup() {
        System.out.println("Initializing user service, create is connections");
    }

    @Override
    public void saveUser() {
        service.save();
        messenger.sendMessage("saved");
    }

    public void cleanCache() {
        System.out.println("Clean cache");
    }
}
