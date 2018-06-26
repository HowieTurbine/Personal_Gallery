package com.hibernate.session;

import com.hibernate.model.IdListEntity;
import com.hibernate.model.ImageEntity;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class DownloadSession {
    private final SessionFactory sessionFactory;

    @Autowired
    public DownloadSession(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }
    public ImageEntity download_by_id(int id)
    {
        Session session = sessionFactory.openSession();
        session.clear();
        Query query = session.createQuery("from ImageEntity A where A.id = "+id);
        List<ImageEntity> list;
        {
            list = query.list();
        }
        for(ImageEntity a:list)
        {

        }
        System.out.println("Size: "+list.size());
        session.close();
        return list.get(0);
    }
    public List<IdListEntity> downloadAll()
    {
        Session session = sessionFactory.openSession();
        session.clear();
        Query query = session.createQuery("from IdListEntity E");
        List<IdListEntity> list;
        {
            list = query.list();
        }
        for(IdListEntity a:list)
        {
            System.out.println(a.getIdImg());
        }
        session.close();
        return list;
    }
}
