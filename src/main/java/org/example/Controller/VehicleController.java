package org.example.Controller;

import org.example.Entity.Vehicle;
import org.example.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ComponentScan
@RequestMapping(value="/vehicles")
@CrossOrigin(origins = {"http://mocker.egen.io", "http://mocker.ennate.academy"})
public class VehicleController {


    private VehicleService vehicleService;

    @Autowired
    public VehicleController(VehicleService vehicleService)
    {
        this.vehicleService=vehicleService;
    }


    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Vehicle> findAll(){
        return vehicleService.findAll();
    }

    @RequestMapping(method = RequestMethod.GET, value = "{vin}")
    public  Vehicle findOne(@PathVariable("vin")   String vin){

       return vehicleService.findOne(vin);
    }

    @RequestMapping(method = RequestMethod.POST)
    Vehicle create(@RequestBody Vehicle vehicle){

        return vehicleService.create(vehicle);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public List<Vehicle> update(@RequestBody List<Vehicle> vehicles){

        return (List<Vehicle>) vehicleService.update(vehicles);

    }


    @RequestMapping(method = RequestMethod.DELETE,value = "{vin}")
    void delete(@PathVariable("vin") String vin){
        vehicleService.delete(vin);

    }
}
