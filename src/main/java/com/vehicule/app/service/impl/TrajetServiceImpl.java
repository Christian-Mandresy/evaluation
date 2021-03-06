package com.vehicule.app.service.impl;

import com.vehicule.app.dao.TrajetDao;
import com.vehicule.app.model.Trajet;
import com.vehicule.app.service.TrajetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TrajetServiceImpl implements TrajetService {
    @Autowired
    TrajetDao trajetDao;

    @Override
    public void save(Trajet trajet)
    {
        trajetDao.save(trajet);
    }

    @Override
    public List findById(int id)
    {
        return trajetDao.findById(id);
    }
}
