package com.zadatak.comping.controller;

import com.zadatak.comping.entity.Service;
import com.zadatak.comping.service.Service_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ServiceController {

    @Autowired
    Service_Service serviceService;

    @GetMapping("/filter/services")
    public List<Service> getServices(@RequestParam Map<String, Object> properties){
        return serviceService.getServices(properties);
    }

    @GetMapping("/services/service-desc")
    public List<String> getServiceDesc(){
        return serviceService.getServiceDesc();
    }

    @PostMapping("/service/{id}")
    public Service addService(@RequestBody Service service, @PathVariable long id){
        return serviceService.addService(service, id);
    }

    @GetMapping("/add-service-provider/{id_service}/{id_provider}")
    public Service addServiceProvider(@PathVariable long id_service, @PathVariable long id_provider){
        return serviceService.addServiceProvider(id_service, id_provider);
    }

    @PutMapping("/service/{id}")
    public void editService(@PathVariable long id, @RequestBody Service service) {
        serviceService.editService(id, service);
    }

    @DeleteMapping("/service/{id}")
    public void deleteService(@PathVariable long id){
        serviceService.deleteService(id);
    }
}
