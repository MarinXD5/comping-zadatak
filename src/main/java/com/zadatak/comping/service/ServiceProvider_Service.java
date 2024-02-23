package com.zadatak.comping.service;

import com.zadatak.comping.entity.ServiceProvider;
import com.zadatak.comping.repository.ServiceProviderRepository;
import com.zadatak.comping.specification.ServiceProviderSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class ServiceProvider_Service {

    @Autowired
    ServiceProviderRepository serviceProviderRepository;

    public List<ServiceProvider> getServiceProvider(Map<String, Object> properties){
        /* Method for ServiceProvider filtering by various properties. Takes in a Map of properties and executes findAll query
           to filter a result by the given properties **/
        try{
            Specification<ServiceProvider> specification = ServiceProviderSpecification.hasProperties(properties);
            return serviceProviderRepository.findAll(specification);
        } catch(Exception e){
            System.out.println("Error while fetching filtered data: " + e.getMessage());
        }
        return null;
    }

    public void addNewServiceProvider(ServiceProvider serviceProvider) {
        /* Method to add a new ServiceProvider. Takes in a ServiceProvider object and saves it in a repo **/
        try {
            ServiceProvider noviPruzatelj = new ServiceProvider();
            noviPruzatelj.setProviderName(serviceProvider.getProviderName());
            serviceProviderRepository.save(noviPruzatelj);
        } catch (Exception e) {
            System.out.println("Error while adding new ServiceProvider: " + e.getMessage());
        }
    }

    public void editServiceProvider(long id, ServiceProvider serviceProvider) {
        /* Method to edit a ServiceProvider object. Takes in an ID and ServiceProvider object **/
        try {
            ServiceProvider serviceProviderFetched = serviceProviderRepository.getReferenceById(id);
            serviceProviderFetched.setProviderName(serviceProvider.getProviderName());
            serviceProviderRepository.save(serviceProviderFetched);
        } catch (Exception e) {
            System.out.println("Error while editing ServiceProvider: " + e.getMessage());
        }
    }

    public void deleteServiceProvider(long id) {
        /* Method to delete a ServiceProvider. Takes in an ID and deletes a ServiceProvider object **/
        try {
            serviceProviderRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error while deleting ServiceProvider: " + e.getMessage());
        }
    }
}