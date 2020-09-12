package org.example.service;

import org.example.Entity.Vehicle;

import java.util.List;


public interface VehicleService {

    List<Vehicle> findAll();
   Vehicle findOne(String vin);
    Vehicle create(Vehicle vehicle);

    List<Vehicle> update(List<Vehicle> vList);

    void delete(String vin);


}
