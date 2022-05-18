package com.vehicule.app.service;


import com.vehicule.app.model.User;

public interface UserService {
    User getUtilisateur(String user, String mdp);
}
