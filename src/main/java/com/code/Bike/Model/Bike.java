package com.code.Bike.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Table(name = "bike")
public class Bike {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;

    private String brand;

    private String image;   // image URL or path

    private Long price;

    private String colour;

    private String mileage;

    private Integer engineCc;

    private Integer topSpeed;

    private String transmission; // Manual / Automatic

    private Integer fuelTankCapacity;

    private Integer yearOfLaunch;

    @Enumerated(EnumType.STRING)
    private BikeType bikeType;

    @Enumerated(EnumType.STRING)
    private FuelType fuelType;

    @Enumerated(EnumType.STRING)
    private BikeStatus status;
}




