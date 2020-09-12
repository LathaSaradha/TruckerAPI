package org.example.service;

import org.example.Entity.Alerts;
import org.example.Entity.Tires;
import org.example.Entity.Vehicle;
import org.example.Entity.VehicleReading;
import org.example.exception.BadRequestException;
import org.example.exception.ReadingNotFoundException;
import org.example.repository.AlertsRepository;
import org.example.repository.VehicleReadingRepository;
import org.example.repository.VehicleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class VehicleReadingServiceImpl implements VehicleReadingService{

    private VehicleReadingRepository vehicleReadingRepository;

    private  VehicleRepository vehicleRepository;

    private AlertsRepository alertRepository;

    @Autowired
    public VehicleReadingServiceImpl(VehicleReadingRepository vehicleReadingRepository,VehicleRepository vehicleRepository,
                                     AlertsRepository alertRepository   )
    {
        this.vehicleReadingRepository=vehicleReadingRepository;
        this.vehicleRepository=vehicleRepository;
        this.alertRepository=alertRepository;
    }

    @Override
    public List<VehicleReading> findAll() {

       return (List<VehicleReading>) vehicleReadingRepository.findAll();

    }

    @Override
    public VehicleReading findOne(String id) {


        Optional<VehicleReading> vr = vehicleReadingRepository.findById(id);

        if(!vr.isPresent())
        {
            throw new ReadingNotFoundException("There is no vehicle reading with id = "+id) ;
        }
        else
        {
            return vr.get();
        }

    }

    @Override
    public VehicleReading create(VehicleReading vehicleReading) {

        Optional<Vehicle> vr = vehicleRepository.findByVin(vehicleReading.getVin());
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat("YYYY-MM-DD hh:mm:ss.s");
        try {
            date = df.parse(String.valueOf(vehicleReading.getTimestamp()));
        }
        catch (ParseException e) {
            System.out.println(e.getMessage());
        }
        if(vr.isPresent())
        {




            if(vehicleReading.getEngineRpm()>vr.get().getRedlineRpm()){
                Alerts alert = new Alerts();
                alert.setVin(vehicleReading.getVin());
                alert.setPriority("HIGH");
                alert.setDescription("RPM is high");
                alert.setTimestamp(date);
                alert.setLatitude(vehicleReading.getLatitude());
                alert.setLongitude(vehicleReading.getLongitude());
                alertRepository.save(alert);

            }

            if(vehicleReading.getFuelVolume()<(0.1*vr.get().getMaxFuelVolume()))
            {Alerts alert = new Alerts();
                alert.setPriority("MEDIUM");
                alert.setVin(vehicleReading.getVin());

                alert.setDescription("Fuel volume is less than 10%");
                alert.setTimestamp(date);
                alert.setLatitude(vehicleReading.getLatitude());
                alert.setLongitude(vehicleReading.getLongitude());
                alertRepository.save(alert);
            }

            Tires tires = vehicleReading.getTires();

            if(tires.getFrontLeft()<32 || tires.getFrontLeft()>36 ||
                    tires.getFrontRight()<32 || tires.getFrontRight()>36 ||
            tires.getRearLeft()<32 || tires.getRearLeft()>36 ||
                    tires.getRearRight()<32 || tires.getRearRight()>36

            )
            {Alerts alert = new Alerts();
                alert.setPriority("LOW");
                alert.setVin(vehicleReading.getVin());
                alert.setDescription("Tire Pressure is Low/High.Check Tire Pressure");
                alert.setTimestamp(date);
                alert.setLatitude(vehicleReading.getLatitude());
                alert.setLongitude(vehicleReading.getLongitude());
                alertRepository.save(alert);
            }

            if(vehicleReading.isEngineCoolantLow() || vehicleReading.isCheckEngineLightOn())
            {Alerts alert = new Alerts();
                alert.setPriority("LOW");
                alert.setVin(vehicleReading.getVin());
                alert.setDescription("EngineCoolant is low or Engine Light is On");
                alert.setTimestamp(date);
                alert.setLatitude(vehicleReading.getLatitude());
                alert.setLongitude(vehicleReading.getLongitude());
                alertRepository.save(alert);
            }


            return vehicleReadingRepository.save(vehicleReading);

        }
        else
        {
            throw new BadRequestException(" The Vehicle Readings are  invalid/incorrect");
        }



    }

    @Override
    public VehicleReading update(String id, VehicleReading vehicleReading) {

        Optional<VehicleReading> vr = vehicleReadingRepository.findById(id);

        if(!vr.isPresent())
        {
            throw new ReadingNotFoundException("There is no vehicle reading with id = "+id) ;
        }
        else
        {
            return vehicleReadingRepository.save(vr.get());
        }



    }

    @Override
    public void delete(String id) {

        Optional<VehicleReading> vr = vehicleReadingRepository.findById(id);
        if(!vr.isPresent())
        {
            throw new ReadingNotFoundException("There is no vehicle reading with id = "+id) ;
        }
        else
        {
             vehicleReadingRepository.delete(vr.get());
        }

    }
}
