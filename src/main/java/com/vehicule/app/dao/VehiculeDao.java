package com.vehicule.app.dao;

import com.vehicule.app.model.Vehicule;

import java.util.List;

public interface VehiculeDao {
    List findall();

    void save(Vehicule vehicule);

    List vehiculeDispo();
}
