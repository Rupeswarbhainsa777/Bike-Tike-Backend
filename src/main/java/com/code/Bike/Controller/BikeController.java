package com.code.Bike.Controller;

import com.code.Bike.Model.Bike;
import com.code.Bike.Service.BikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bike")
public class BikeController {

    @Autowired
    private BikeService bikeService;

    @PostMapping("/add")
   public Bike add(@RequestBody Bike bike){
        return bikeService.saveBike(bike);
   }

   @GetMapping("/all")
   public ResponseEntity<List<Bike>> getAll(){
        return bikeService.getAlll();
   }

   @GetMapping("/get/{id}")
   public ResponseEntity<Bike> get(@PathVariable int id){
        return bikeService.get(id);

   }
   @DeleteMapping("/delete/{id}")
   public ResponseEntity<String> delete(@PathVariable int id){
        return bikeService.delete(id);

   }
}
