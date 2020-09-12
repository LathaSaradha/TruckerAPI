package org.example.service;

import org.example.Entity.Vehicle;
import org.example.Entity.VehicleReading;

import java.util.List;

public interface VehicleReadingService {

    List<VehicleReading> findAll();
    VehicleReading findOne(String id);
    VehicleReading create(VehicleReading vehicleReading);

    VehicleReading update(String id, VehicleReading vehicleReading);

    void delete(String id);
}
