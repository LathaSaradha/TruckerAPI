package org.example.service;

import org.example.Entity.Alerts;

import java.util.List;

public interface AlertsService  {

    List<Alerts> findAll();
    Alerts findOne(String id);
    Alerts create(Alerts alerts);

    Alerts update(String id, Alerts alerts);

    void delete(String id);

    List<Alerts> findByPriority(String priority);

    List<Alerts> findAlertsByVin(String vin);


}
