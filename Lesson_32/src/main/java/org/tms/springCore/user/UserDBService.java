package org.tms.springCore.user;

public class UserDBService implements UserService {
    @Override
    public void save() {
        System.out.println("Save to database");
    }
}
