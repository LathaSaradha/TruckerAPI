package org.example.repository;

import org.example.Entity.Vehicle;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle,String> {

    Optional<Vehicle> findByVin(String vin);
}
