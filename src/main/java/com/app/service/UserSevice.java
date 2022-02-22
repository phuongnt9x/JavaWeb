package com.app.service;

import com.app.model.User;
import com.app.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserSevice implements IUserService{
    @Autowired
    private UserRepo userRepo;
    @Override
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    public Iterable<User> findAll() {
        return userRepo.findAll();
    }
}
