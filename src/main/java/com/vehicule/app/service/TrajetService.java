package com.vehicule.app.service;

import com.vehicule.app.model.Trajet;

import java.util.List;

public interface TrajetService {
    void save(Trajet trajet);

    List findById(int id);
}
