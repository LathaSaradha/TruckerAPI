package org.example.Controller;


import org.example.Entity.VehicleReading;
import org.example.service.VehicleReadingService;
import org.example.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ComponentScan
@RequestMapping("/readings")
@CrossOrigin(origins = {"http://mocker.egen.io", "http://mocker.ennate.academy"})
public class VehicleReadingController {

    private VehicleReadingService vehicleReadingService;


    @Autowired
    public VehicleReadingController(VehicleReadingService service)
    {
        this.vehicleReadingService = service;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<VehicleReading> findAll() {
        return vehicleReadingService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public VehicleReading create(@RequestBody VehicleReading reading) {

        return vehicleReadingService.create(reading);
    }

    @RequestMapping(method = RequestMethod.POST,value="{id}")
    public VehicleReading update(@PathVariable("id") String id,@RequestBody  VehicleReading vehicleReading){
        return vehicleReadingService.update(id,vehicleReading);
    }
}
