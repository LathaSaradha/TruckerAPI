/*
package org.example.service;

import org.example.Entity.Tires;
import org.example.Entity.Vehicle;
import org.example.exception.BadRequestException;
import org.example.exception.TiresNotFoundException;
import org.example.exception.VehicleNotFoundException;
import org.example.repository.TiresRepository;
import org.example.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TiresServiceImpl implements TiresService {

    private TiresRepository tiresRepository;

    @Autowired
    public TiresServiceImpl(TiresRepository tiresRepository)
    {
        this.tiresRepository=tiresRepository;
    }

    @Override
    public List<Tires> findAll() {

        return (List<Tires>) tiresRepository.findAll();



    }

    @Override
    public Tires findOne(String id) {


                Optional<Tires> tires= tiresRepository.findById(id);


        if(!tires.isPresent())
        {
            throw new VehicleNotFoundException("Vehicle with vin = " + id + " not found");
        }
        else
        {
            return tires.get();
        }


    }

    @Override
    public Tires create(Tires tire) {

        Optional<Tires> tires= tiresRepository.findById(tire.getId());
        if(tires.isPresent())
        {
            throw new BadRequestException("Vehicle with vin = "+tires.get().getId() +" is already present.");
        }
        else{
            return  tiresRepository.save(tire);
        }


    }

    @Override
    public Tires update(String id, Tires tire) {

        Optional<Tires> tires= tiresRepository.findById(id);
        if(!tires.isPresent())
        {
            throw new TiresNotFoundException("Tired with id = " + id + " not found");
        }
        else{
            return  tiresRepository.save(tire);
        }


    }

    @Override
    public void delete(String id) {

        Optional<Tires> tires= tiresRepository.findById(id);
        if(!tires.isPresent())
        {throw new TiresNotFoundException("Tired with id = " + id + " not found");
        }
        else{
            tiresRepository.delete(tires.get());
        }

    }
}
*/
