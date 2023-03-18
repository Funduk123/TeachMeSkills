package org.tms.springCore.message;

public class TelegramMessenger implements Messenger {
    @Override
    public void sendMessage(String text) {
        System.out.println("Send to Telegram: " + text);
    }
}
