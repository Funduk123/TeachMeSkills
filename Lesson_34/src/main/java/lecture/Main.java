package lecture;

import lecture.aop.service.UserHandler;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;


public class Main {
    public static void main(String[] args) {

        AbstractApplicationContext context = new AnnotationConfigApplicationContext("lecture");
        UserHandler bean = context.getBean(UserHandler.class);

        bean.saveUser();

        context.close();
    }
}
