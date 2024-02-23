package com.zadatak.comping.controller;

import com.zadatak.comping.entity.Service;
import com.zadatak.comping.repository.ServiceRepository;
import com.zadatak.comping.service.Service_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureOrder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ServiceController {

    @Autowired
    Service_Service serviceService;

    @Autowired
    ServiceRepository serviceRepository;


    @GetMapping("/services")
    public List<Service> getAllServices(){
        return serviceRepository.findAll();
    }

    @GetMapping("/getService/{id}")
    public Service getServiceById(@PathVariable long id){
        return serviceService.findByID(id);
    }

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

    @PutMapping("/service/{id_service}/{id_provider_existing}/{id_provider_wanted}")
    public void editService(@PathVariable long id_service,@PathVariable long id_provider_existing, @PathVariable long id_provider_wanted, @RequestBody Service service) {
        serviceService.editService(id_service,id_provider_existing,id_provider_wanted, service);
    }

    @DeleteMapping("/service/{id}")
    public void deleteService(@PathVariable long id){
        serviceService.deleteService(id);
    }
}
