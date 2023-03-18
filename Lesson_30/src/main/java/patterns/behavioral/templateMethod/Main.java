package patterns.behavioral.templateMethod;

import patterns.behavioral.templateMethod.service.UserHandler;

public class Main {
    public static void main(String[] args) {

        UserHandler userHandler = new UserHandler();

        userHandler.saveUser("Danila", "12345", null, true);

    }
}
