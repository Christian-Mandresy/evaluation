package com.vehicule.app.service.impl;

import com.vehicule.app.dao.VehiculeDao;
import com.vehicule.app.model.Vehicule;
import com.vehicule.app.service.VehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculeServiceImpl implements VehiculeService {
    private VehiculeDao vehiculeDao;

    @Autowired
    public void setVehiculeDao(VehiculeDao vehiculeDao) {
        this.vehiculeDao = vehiculeDao;
    }

    @Override
    public void save(Vehicule vehicule)
    {
        vehiculeDao.save(vehicule);
    }

    @Override
    public List vehiculeDispo()
    {
        return vehiculeDao.vehiculeDispo();
    }
}
