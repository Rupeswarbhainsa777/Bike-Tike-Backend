package com.code.Bike.Repository;

import com.code.Bike.Model.Bike;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BikeRepository extends JpaRepository<Integer, Bike> {

}
