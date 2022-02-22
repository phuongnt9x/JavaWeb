package com.app.service;

import com.app.model.User;

public interface IUserService {
    void save(User user);
    Iterable<User> findAll();
}
