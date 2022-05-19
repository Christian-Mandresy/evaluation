package com.vehicule.app.dao;

import com.vehicule.app.model.Trajet;

import java.util.List;

public interface TrajetDao {
    void save(Trajet trajet);

    List findById(int id);
}
