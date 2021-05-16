package com.example.etstest.service.impl;

import com.example.etstest.dao.UserDAO;
import com.example.etstest.model.User;
import com.example.etstest.service.UserQueryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserQueryServiceImpl implements UserQueryService {

    @Autowired
    private UserDAO userDAO;

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
