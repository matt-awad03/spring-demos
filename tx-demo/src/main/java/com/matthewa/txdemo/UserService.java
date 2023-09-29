package com.matthewa.txdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepo;

    @Transactional
    public Long addUser(User user) {
        userRepo.save(user);
        return user.getId();
    }
}
