package com.tms.one_to_one.service;

import com.tms.one_to_one.domain.Phone;
import com.tms.one_to_one.domain.UserEntity;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService extends AbstractUserService{

    public void save(UserEntity user) {
        Session session = getSession();

        session.save(user);
        Phone phone = user.getPhone();
        phone.setUser(user);
        session.save(phone);

        closeSession(session);
    }

    public UserEntity get(Integer id) {
        Session session = getSession();

        UserEntity userEntity = session.find(UserEntity.class, id);

        closeSession(session);

        return userEntity;
    }

    public void delete(Integer id) {
        Session session = getSession();

        UserEntity userEntity = session.find(UserEntity.class, id);
        Phone phoneEntity = session.find(Phone.class, id);
        session.delete(userEntity);
        session.delete(phoneEntity);

        closeSession(session);
    }

    public Phone getPhone(Integer id) {
        Session session = getSession();

        Phone phone = session.find(Phone.class, id);

        closeSession(session);

        return phone;
    }

}
