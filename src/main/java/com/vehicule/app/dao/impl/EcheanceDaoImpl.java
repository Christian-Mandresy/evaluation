package com.vehicule.app.dao.impl;

import com.vehicule.app.dao.EcheanceDao;
import com.vehicule.app.model.Echeance;
import com.vehicule.app.model.TypeVehicule;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EcheanceDaoImpl implements EcheanceDao {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public List findall()
    {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            List type = session.createCriteria(Echeance.class).list();
            tx.commit();
            int i=0;
            return type;
        } catch (Exception e) {
            if (tx != null) {
                tx.rollback();
            }
            throw e;
        } finally {
            session.close();
        }
    }
}
