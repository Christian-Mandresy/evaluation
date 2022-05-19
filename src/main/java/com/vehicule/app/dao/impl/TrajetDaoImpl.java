package com.vehicule.app.dao.impl;

import com.vehicule.app.dao.TrajetDao;
import com.vehicule.app.model.Trajet;
import com.vehicule.app.model.Vehicule;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class TrajetDaoImpl implements TrajetDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Trajet trajet)
    {
        Session session=this.sessionFactory.openSession();
        Transaction tx = null;
        try
        {
            tx=session.beginTransaction();
            session.save(trajet);
            tx.commit();
        }
        catch (Exception e)
        {
            tx.rollback();
            throw e;
        }
        finally {
            session.close();
        }
    }
}
