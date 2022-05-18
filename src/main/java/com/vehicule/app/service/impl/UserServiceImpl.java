package com.vehicule.app.service.impl;


import com.vehicule.app.dao.UserDao;
import com.vehicule.app.model.User;
import com.vehicule.app.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;

    @Override
    public User getUtilisateur(String user, String mdp)
    {
        return userDao.getUtilisateur(user,mdp);
    }
}
