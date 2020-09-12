package org.example.service;

import org.example.Entity.Alerts;
import org.example.exception.AlertsNotFoundException;
import org.example.repository.AlertsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlertsServiceImpl implements AlertsService{

    private AlertsRepository alertsRepository;

        @Autowired
        public AlertsServiceImpl(AlertsRepository alertsRepository)
        {
            this.alertsRepository=alertsRepository;
        }

    @Override
    public List<Alerts> findAll() {

        return (List<Alerts>) alertsRepository.findAll();
    }

    @Override
    public Alerts findOne(String id) {

        Optional<Alerts> alert = alertsRepository.findById(id);

        if(!alert.isPresent())
        {
            throw new AlertsNotFoundException("Alert with id = "+id+ " is not found");
        }
        else
        {
            return alert.get();
        }

    }

    @Override
    public Alerts create(Alerts alerts) {

        return alertsRepository.save(alerts);

    }

    @Override
    public Alerts update(String id, Alerts alerts) {

        Optional<Alerts> alert = alertsRepository.findById(id);

        if(!alert.isPresent())
        {
            throw new AlertsNotFoundException("Alert with id = "+id+ " is not found");
        }
        else
        {
            return alertsRepository.save(alerts);
        }

    }

    @Override
    public void delete(String id) {

        Optional<Alerts> alert = alertsRepository.findById(id);

        if(!alert.isPresent())
        {
            throw new AlertsNotFoundException("Alert with id = "+id+ " is not found");
        }
        else
        {
            alertsRepository.delete(alert.get());
        }

    }

    @Override
    public List<Alerts> findByPriority(String priority) {

        Iterable<Alerts> existing = alertsRepository.findByPriority(priority);


        if(!existing.iterator().hasNext()) {
            throw new AlertsNotFoundException("Alerts for Vehicles with Priority:- "+priority+" not found");
        }
        return (List<Alerts>) existing;


    }

    @Override
    public List<Alerts> findAlertsByVin(String vin) {
        Iterable<Alerts> existing =  alertsRepository.findByVin(vin);
        if(!existing.iterator().hasNext()) {
            throw new AlertsNotFoundException("Alerts for Vehicles with vin:- "+vin+" not found");
        }
        return (List<Alerts>) existing;


    }
}
