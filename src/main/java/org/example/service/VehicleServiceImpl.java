package org.example.service;

import org.example.Entity.Vehicle;
import org.example.exception.BadRequestException;
import org.example.exception.VehicleNotFoundException;
import org.example.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleServiceImpl implements VehicleService {

    @Autowired
    private VehicleRepository vehicleRepository;

    @Autowired
    public VehicleServiceImpl(VehicleRepository vr)
    {
        this.vehicleRepository=vr;
    }

    @Override
    @Transactional
    public List<Vehicle> findAll() {

        return (List<Vehicle>) vehicleRepository.findAll();

    }

    @Override
    @Transactional
    public Vehicle findOne(String vin) {


        Optional<Vehicle> vehicle= vehicleRepository.findById(vin);


        if(!vehicle.isPresent())
        {
            throw new VehicleNotFoundException("Vehicle with vin = " + vin + " not found");
        }
        else
        {
            return vehicle.get();
        }


    }




    @Override
    @Transactional
    public Vehicle create(Vehicle vehicle) {

        Optional<Vehicle> vehicle1= vehicleRepository.findById(vehicle.getVin());
        if(vehicle1.isPresent())
        {
            throw new BadRequestException("Vehicle with vin = "+vehicle1.get().getVin() +" is already there.");
        }
        else{
           return  vehicleRepository.save(vehicle);
        }


    }


    @Override
    @Transactional
    public List<Vehicle> update(List<Vehicle> vList) {
        vList.forEach(v -> {
            if(!vehicleRepository.findById(v.getVin()).isPresent()) {
                System.out.println(v.getLastServiceDate());
            }
        });
        return (List<Vehicle>) vehicleRepository.saveAll(vList);
    }

    @Override
    @Transactional
    public void delete(String vin) {

        Optional<Vehicle> vehicle1= vehicleRepository.findById(vin);
        if(!vehicle1.isPresent())
        {throw new VehicleNotFoundException("Vehicle with vin = " + vin + " not found");
        }
        else{
             vehicleRepository.delete(vehicle1.get());
        }

    }
}
