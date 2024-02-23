package com.zadatak.comping.controller;

import com.zadatak.comping.entity.Service;
import com.zadatak.comping.entity.ServiceProvider;
import com.zadatak.comping.repository.ServiceProviderRepository;
import com.zadatak.comping.service.ServiceProvider_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class ServiceProviderController {

    @Autowired
    ServiceProvider_Service serviceProviderService;

    @Autowired
    ServiceProviderRepository serviceProviderRepository;

    @GetMapping("/providers")
    public List<ServiceProvider> getProviders(){
        List<ServiceProvider> list = serviceProviderRepository.findAll();
        return list;
    }

    @GetMapping("/service-provider")
    public List<ServiceProvider> getServiceProvider(@RequestParam Map<String, Object> properties){
        return serviceProviderService.getServiceProvider(properties);
    }

    @PostMapping("/service-provider")
    public void addNewServiceProvider(@RequestBody ServiceProvider serviceProvider) {
        serviceProviderService.addNewServiceProvider(serviceProvider);
    }

    @PutMapping("/service-provider/{id}")
    public void editServiceProvider(@PathVariable Long id, @RequestBody ServiceProvider serviceProvider){
        serviceProviderService.editServiceProvider(id, serviceProvider);
    }

    @DeleteMapping("/service-provider/{id}")
    public void deleteServiceProvider(@PathVariable Long id){
        serviceProviderService.deleteServiceProvider(id);
    }
}
