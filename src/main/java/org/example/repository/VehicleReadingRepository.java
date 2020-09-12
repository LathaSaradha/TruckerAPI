package org.example.repository;

import org.example.Entity.VehicleReading;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehicleReadingRepository extends CrudRepository<VehicleReading,String> {
}
