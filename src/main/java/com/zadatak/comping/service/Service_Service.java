package com.zadatak.comping.service;

import com.zadatak.comping.entity.ServiceProvider;
import com.zadatak.comping.entity.Service;
import com.zadatak.comping.projections.ServiceDescriptionProjection;
import com.zadatak.comping.repository.ServiceProviderRepository;
import com.zadatak.comping.repository.ServiceRepository;
import com.zadatak.comping.specification.ServiceSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@org.springframework.stereotype.Service
public class Service_Service {

    @Autowired
    ServiceRepository serviceRepository;

    @Autowired
    ServiceProviderRepository serviceProviderRepository;

    public Service addService(Service service, long id){
        /* Method to add and connect service with its provider. Takes in a Service (engl. Service) entity
        *  and an ID of a ServiceProvider (engl. ServiceProvider) entity. The ServiceProvider HAS to exist prior
        *  to trying to connect the two!!! Returns a newly created Service **/
        Optional<ServiceProvider> serviceProvider = serviceProviderRepository.findById(id);

        if(serviceProvider.isPresent()){
            service.getServiceProviders().add(serviceProvider.get());
            serviceRepository.save(service);
            return service;
        }
        return null;
    }

    public List<Service> getServices(Map<String, Object> properties){
        /* Method for Service filtering by various properties. Takes in a Map of properties and executes findAll query
           to filter a result by the given properties **/
        try{
            Specification<Service> specification = ServiceSpecification.hasProperties(properties);
            return serviceRepository.findAll(specification);
        } catch(Exception e){
            System.out.println("Error while fetching filtered data: " + e.getMessage());
        }
        return null;
    }

    public List<String> getServiceDesc() {
        /* Method to fetch service description using projections **/
        try {
            List<ServiceDescriptionProjection> opisUsluga = serviceRepository.findAllServiceDescription();
            List<String> serviceDescriptionList = new ArrayList<>();

            for (ServiceDescriptionProjection projection : opisUsluga) {
                serviceDescriptionList.add(projection.getServiceDescription());
            }
            return serviceDescriptionList;
        } catch (Exception e) {
            System.out.println("Error while fetching serviceDescriptions: " + e.getMessage());
        }
        return null;
    }

    public void editService(long id, Service service) {
        /* Method for editing a Service (engl. Service) object. Takes in ID and Service object **/
        try {
            Service serviceFetched = serviceRepository.getReferenceById(id);
            serviceFetched.setServiceDescription(service.getServiceDescription());
            serviceRepository.save(serviceFetched);
        } catch (Exception e) {
            System.out.println("Error while editing service: " + e.getMessage());
        }
    }

    public void deleteService(long id) {
        /* Method to delete a Service (engl. Service). Takes in an ID and Service object **/
        try {
            serviceRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error while deleting service: " + e.getMessage());
        }
    }

    public Service addServiceProvider(long idService, long idProvider) {
        try{
            Service service = serviceRepository.getReferenceById(idService);
            ServiceProvider serviceProvider = serviceProviderRepository.getReferenceById(idProvider);
            service.getServiceProviders().add(serviceProvider);
            serviceRepository.save(service);
            return service;
        } catch(Exception e){
            System.out.println("Error while fetching service or service provider: " + e.getMessage());
        }
        return null;
    }
}