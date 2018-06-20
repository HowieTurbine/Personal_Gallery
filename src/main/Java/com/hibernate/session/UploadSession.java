package com.hibernate.session;

import com.hibernate.model.ImageEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UploadSession {
    private final SessionFactory sessionFactory;

    @Autowired
    public UploadSession(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public void Upload(ImageEntity imageEntity)
    {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.save(imageEntity);
        transaction.commit();
        session.close();
    }
}
