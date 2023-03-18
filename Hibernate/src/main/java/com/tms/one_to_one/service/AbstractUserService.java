package com.tms.one_to_one.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;


public class AbstractUserService {

    @Autowired
    private SessionFactory factory;

    public Session getSession() {
        Session session = factory.openSession();
        session.beginTransaction();
        return session;
    }

    public void closeSession(Session session) {
        Transaction transaction = session.getTransaction();
        transaction.commit();
        session.close();
    }

}
