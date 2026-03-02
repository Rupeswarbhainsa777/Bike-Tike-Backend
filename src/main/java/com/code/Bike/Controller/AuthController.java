package com.code.Bike.Controller;


import com.code.Bike.Model.User;
import com.code.Bike.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequiredArgsConstructor
@RequestMapping("/user")
public class AuthController {

    @Autowired
    private UserService userService;



    @PostMapping("/add")
    public User addUser(@RequestBody User user){
         return userService.adduser(user);
    }
}
