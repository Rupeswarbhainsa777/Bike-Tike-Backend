package com.code.Bike.Service;


import com.code.Bike.Model.Bike;
import com.code.Bike.Repository.BikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BikeService {

    @Autowired
    private BikeRepository bikeRepository;

    public Bike saveBike(Bike bike){
        return bikeRepository.save(bike);
    }


    public ResponseEntity<List<Bike>> getAlll(){
        try {
            return new ResponseEntity<>(bikeRepository.findAll(), HttpStatus.OK);

        }
        catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.BAD_REQUEST);
    }

    public ResponseEntity<Bike> get(int id){
        try {
            return bikeRepository.findById(id)
                    .map(bike -> new ResponseEntity<>(bike, HttpStatus.OK))
                    .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

    }
    public ResponseEntity<String> delete(int id) {
        try {
            if (!bikeRepository.existsById(id)) {
                return new ResponseEntity<>("Bike not found", HttpStatus.NOT_FOUND);
            }

            bikeRepository.deleteById(id);
            return new ResponseEntity<>("Bike deleted successfully", HttpStatus.OK);

        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("Error while deleting bike", HttpStatus.BAD_REQUEST);
        }
    }

}
