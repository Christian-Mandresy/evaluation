package com.vehicule.app.service;

import com.vehicule.app.model.Vehicule;

import java.util.List;

public interface VehiculeService {
    void save(Vehicule vehicule);

    List vehiculeDispo();

    List findall();
}
