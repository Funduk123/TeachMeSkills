package org.tms.springCore.user;

public class UserFileService implements UserService {

    public UserFileService() {
        System.out.println("Create user file");
    }

    @Override
    public void save() {
        System.out.println("Save to file");
    }
}
