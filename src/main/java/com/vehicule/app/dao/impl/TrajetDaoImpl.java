package com.vehicule.app.dao.impl;

import com.vehicule.app.dao.TrajetDao;
import com.vehicule.app.model.Trajet;
import com.vehicule.app.model.TypeVehicule;
import com.vehicule.app.model.Vehicule;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    @Override
    public List findById(int id)
    {
        Session session = this.sessionFactory.openSession();
        Transaction tx = null;
        try {
            tx = session.beginTransaction();
            Criteria criteria=session.createCriteria(Trajet.class);
            Criterion criterion= Restrictions.eq("id_vehicule", id);
            criteria.add(criterion);
            List type=criteria.list();
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
