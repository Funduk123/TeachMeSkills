package patterns.behavioral.templateMethod.service;

import java.util.Date;

public class UserHandler {

    private SaveService saveService;

    public void saveUser(String login, String password, Date birthday, boolean isAdmin) {

        if (isAdmin) {
            saveService = new AdminSaveService();
        } else {
            saveService = new UserSaveService();
        }

        saveService.save(login, password, birthday);

    }

}
