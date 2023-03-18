package org.tms.springCore.message;

public class MailMessenger implements Messenger {

    public MailMessenger() {
        System.out.println("Create mail");
    }

    @Override
    public void sendMessage(String text) {
        System.out.println("Send to Mail: " + text);
    }
}
