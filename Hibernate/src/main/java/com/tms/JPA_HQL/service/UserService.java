package com.tms.JPA_HQL.service;

import com.tms.JPA_HQL.domain.Phone;
import com.tms.JPA_HQL.domain.Role;
import com.tms.JPA_HQL.domain.UserEntity;
import lombok.RequiredArgsConstructor;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class UserService extends AbstractUserService {

    public void save(UserEntity user) {
        Session session = getSession();

//        List<Phone> phones = user.getPhones();
//        phones.forEach(session::save);

        session.save(user);

//        user.setPhones(phones);

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

    public Set<UserEntity> getByRole(Role role) {
        Session session = getSession();

        Query<UserEntity> query = session.createQuery("from UserEntity as p left join fetch p.phones where p.role = :role", UserEntity.class);
        query.setParameter("role", role);
        List<UserEntity> list = query.list();

        closeSession(session);

        return new HashSet<>(list);
    }

    public List<UserEntity> getBy(String login, Role role) {
        Session session = getSession();

        Criteria criteria = session.createCriteria(UserEntity.class);

        if (login != null && login.isBlank()) {
            criteria.add(Restrictions.eq("login", login));
        }

        criteria.add(Restrictions.eq("role", role));

        criteria.add(Restrictions.ge("salary", 2000));

        return (List<UserEntity>) criteria.list();

    }

    // Оптимистическая блокировка
    public void update(Integer id, String description) {
        Session session = getSession();

        UserEntity userEntity = session.find(UserEntity.class, id);
        userEntity.setDescription(description);

        closeSession(session);
    }

    // Оптимистическая блокировка
    public void testOptimisticLock(Integer id, String description) {
        Session session = getSession();

        UserEntity userEntity = session.find(UserEntity.class, id);
        userEntity.setDescription(description);

        closeSession(session);
    }

}
