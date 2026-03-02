package com.code.Bike.Service;

import com.code.Bike.Model.User;
import com.code.Bike.Repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public User adduser(User user){
        return userRepo.save(user);
    }
}
