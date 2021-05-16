package com.example.etstest.service.impl;

import com.example.etstest.dao.UserDAO;
import com.example.etstest.model.User;
import com.example.etstest.service.UserCommandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserCommandServiceImpl implements UserCommandService {

    @Autowired
    private UserDAO userDAO;

    public void save(User aUser) {
        try {
            userDAO.save(aUser);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(Long userId) {
        try {
            userDAO.delete(userId);
        } catch (Exception e) {
            e.printStackTrace();
        }
   }
}
