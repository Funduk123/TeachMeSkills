package com.tms.many_to_many.service;

import com.tms.many_to_many.domain.Phone;
import com.tms.many_to_many.domain.UserEntity;
import lombok.RequiredArgsConstructor;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService extends AbstractUserService {

    public void save(UserEntity user) {
        Session session = getSession();

        List<Phone> phones = user.getPhones();
        phones.forEach(session::save);

        session.save(user);

        user.setPhones(phones);

        closeSession(session);
    }

    public UserEntity get(Integer id) {
        Session session = getSession();

        UserEntity userEntity = session.find(UserEntity.class, id);
        List<Phone> phones = userEntity.getPhones();
        phones.forEach(System.out::println);

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
