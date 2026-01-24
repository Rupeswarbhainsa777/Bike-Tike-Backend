package com.code.Bike.Controller;

import com.code.Bike.Model.Bike;
import com.code.Bike.Service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bike")
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @PostMapping("/add")
   public Bike add(@RequestBody Bike bike){
       return bikeService.saveBike(bike);
   }
}
