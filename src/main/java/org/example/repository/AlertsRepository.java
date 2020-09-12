package org.example.repository;

import org.example.Entity.Alerts;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlertsRepository extends CrudRepository<Alerts,String> {

    Iterable<Alerts> findByPriority(String priority);

    Iterable<Alerts> findByVin(String vin);
}
