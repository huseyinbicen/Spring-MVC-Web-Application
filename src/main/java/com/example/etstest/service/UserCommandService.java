package com.example.etstest.service;

import com.example.etstest.model.User;

public interface UserCommandService {

    void save(User aUser);

    void delete(Long userId);
}
