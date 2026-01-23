package com.code.Bike.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bike")
public class BikeController {

    @GetMapping("/hi")
    public String hello(){
        return "Hii";
    }
}
