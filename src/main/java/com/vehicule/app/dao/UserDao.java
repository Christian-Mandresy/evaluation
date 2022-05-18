package com.vehicule.app.dao;

import com.vehicule.app.model.User;

public interface UserDao {
    User getUtilisateur(String util, String mdp);
}
