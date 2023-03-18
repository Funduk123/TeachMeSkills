package com.tms.homework_38.service;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;


public class AbstractTeacherService {

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
