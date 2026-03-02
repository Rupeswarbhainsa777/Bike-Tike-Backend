package com.code.Bike.Controller;


import com.code.Bike.Model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequiredArgsConstructor
public class AuthController {

    public User addUser(@RequestBody User user){

    }
}
