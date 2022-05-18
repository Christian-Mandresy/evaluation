package com.vehicule.app.service.impl;

import com.vehicule.app.dao.TypeVehiculeDao;
import com.vehicule.app.service.TypeVehiculeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeVehiculeServiceImpl implements TypeVehiculeService {

    private TypeVehiculeDao typeVehiculeDao;

    @Autowired
    public void setTypeVehiculeDao(TypeVehiculeDao typeVehiculeDao) {
        this.typeVehiculeDao = typeVehiculeDao;
    }

    @Override
    public List findall()
    {
        return typeVehiculeDao.findall();
    }
}
