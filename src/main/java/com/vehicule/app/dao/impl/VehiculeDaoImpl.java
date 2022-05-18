package com.vehicule.app.dao.impl;

import com.vehicule.app.dao.VehiculeDao;
import com.vehicule.app.model.Vehicule;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class VehiculeDaoImpl implements VehiculeDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Vehicule vehicule)
    {
        Session session=this.sessionFactory.openSession();
        Transaction tx = null;
        try
        {
            tx=session.beginTransaction();
            session.save(vehicule);
            tx.commit();
        }
        catch (Exception e)
        {
            tx.rollback();
        }
        finally {
            session.close();
        }
    }
}
