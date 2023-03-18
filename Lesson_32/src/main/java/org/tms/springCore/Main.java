package org.tms.springCore;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.tms.springCore.message.Messenger;
import org.tms.springCore.user.UserHandler;

public class Main {
    public static void main(String[] args) {

        AbstractApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

//        Messenger bean = context.getBean(Messenger.class);
//        bean.sendMessage("first message");

//        Map<String, Messenger> beansOfType = context.getBeansOfType(Messenger.class);
//        beansOfType.forEach((s, messenger) -> messenger.sendMessage("message"));

        UserHandler bean = context.getBean(UserHandler.class);
        bean.saveUser();

        System.out.println();

        UserHandler bean1 = context.getBean(UserHandler.class);
        bean1.saveUser();

        context.close();
    }
}