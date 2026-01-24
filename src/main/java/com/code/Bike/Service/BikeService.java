package com.code.Bike.Service;


import com.code.Bike.Model.Bike;
import com.code.Bike.Repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    public Bike saveBike(Bike bike){
        return bikeRepository.save(bike);
    }

}
