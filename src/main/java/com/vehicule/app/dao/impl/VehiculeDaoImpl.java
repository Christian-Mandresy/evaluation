package com.vehicule.app.dao.impl;

import com.vehicule.app.dao.VehiculeDao;
import com.vehicule.app.model.Echeance;
import com.vehicule.app.model.TypeVehicule;
import com.vehicule.app.model.Vehicule;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

@Repository
public class VehiculeDaoImpl implements VehiculeDao {
    @Autowired
    private SessionFactory sessionFactory;

    @Autowired
    private EcheanceDaoImpl echeanceDao;

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
            throw e;
        }
        finally {
            session.close();
        }
    }

    @Override
    public List vehiculeDispo()
    {

        Session session = this.sessionFactory.openSession();
        try {

            StringBuilder sql=new StringBuilder("select * from vehicule where vehicule.id not in ( select id_vehicule from trajetencour where idfini is null) " +
                    "and vehicule.id in ");

            List<Echeance> typa= echeanceDao.findall();
            for (int i = 0; i <typa.size() ; i++) {
                if(i!=typa.size()-1)
                {
                    sql.append(" (select id_vehicule from echeancevehicule where restant>0 and echeancevehicule.id= "+typa.get(i).getId()+") and vehicule.id in ");
                }
                else
                {
                    sql.append(" (select id_vehicule from echeancevehicule where restant>0 and echeancevehicule.id= "+typa.get(i).getId()+")");
                }
            }

            String queryFinal=sql.toString();

            SQLQuery query= session.createSQLQuery(queryFinal)
                    .addEntity(Vehicule.class);
            List resultat = query.list();
            return resultat;
        } catch (Exception e) {
            throw e;
        }
        finally {
            session.close();
        }
    }
}
