package org.example.Controller;


import io.swagger.annotations.ApiOperation;
import org.example.Entity.Alerts;
import org.example.service.AlertsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@ComponentScan
@RequestMapping(value="/alerts")
public class AlertsController {

    private AlertsService alertsService;

    @Autowired
    public AlertsController(AlertsService service)
    {this.alertsService=service;}

    @ApiOperation(value = "To List all the alerts.")
    @RequestMapping(method = RequestMethod.GET)
    public List<Alerts> findAll(){

      return  alertsService.findAll();
    }


    @RequestMapping(method = RequestMethod.GET, value = "{id}")
    Alerts findOne(@PathVariable("id") String id){
        return  alertsService.findOne(id);
    }

    @RequestMapping(method =RequestMethod.POST)
    Alerts create(@RequestBody  Alerts alerts){

        return alertsService.create(alerts);

    }


    @RequestMapping(method =RequestMethod.PUT, value = "{id}")
    public Alerts update(@PathVariable("id") String id,@RequestBody Alerts alerts){

        return alertsService.update(id,alerts);
    }

    @RequestMapping(method =RequestMethod.DELETE, value="{id}")
   public void delete(@PathVariable("id") String id){

        alertsService.delete(id);
    }

    @RequestMapping(method =RequestMethod.GET,value="/priority/{priority}")
   public List<Alerts> findByPriority(@PathVariable("priority")String priority){

        return  alertsService.findByPriority(priority);
    }


    @RequestMapping(method =RequestMethod.GET,value="/vin/{vin}")
    List<Alerts> findAlertsByVin(String vin){
       return alertsService.findAlertsByVin(vin);
    }




}
