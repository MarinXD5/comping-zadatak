package com.zadatak.comping.service;

import com.zadatak.comping.entity.PruzateljUsluge;
import com.zadatak.comping.repository.PruzateljUslugaRepository;
import com.zadatak.comping.specification.PruzateljUslugaSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class PruzateljUslugeService {

    @Autowired
    private PruzateljUslugaRepository pruzateljUslugaRepository;

    public List<PruzateljUsluge> getUsluge(Map<String, Object> properties){
        /* Metoda za filtriranje usluga po raznim propertijima. Prima listu propertija i nad njima vrsi querry findAll
         *  kako bi se profiltrirao rezultat po zadanim parametrima **/
        try{
            Specification<PruzateljUsluge> specification = PruzateljUslugaSpecification.hasProperties(properties);
            return pruzateljUslugaRepository.findAll(specification);
        } catch(Exception e){
            System.out.println("Error while fetching filtered data: " + e.getMessage());
        }
        return null;
    }

    public void addNewPruzatelj(PruzateljUsluge pruzateljUsluge) {
        /* Metoda za dodavanje novog pruzatelja usluga. Prima request body i kreira novi PruzateljUsluge objekt te setira
         *  odgovarajuća polja. **/
        try {
            PruzateljUsluge noviPruzatelj = new PruzateljUsluge();
            noviPruzatelj.setNazivPruzatelja(pruzateljUsluge.getNazivPruzatelja());
            pruzateljUslugaRepository.save(noviPruzatelj);
        } catch (Exception e) {
            System.out.println("Error while adding new PruzateljUsluge: " + e.getMessage());
        }
    }

    public void editPruzatelj(Long id, PruzateljUsluge pruzateljUsluge) {
        /* Metoda za uređivanje PruzateljUsluge objekta. Prima id i PruzateljUsluge objekt **/
        try {
            PruzateljUsluge pruzateljUslugeFetched = pruzateljUslugaRepository.getReferenceById(id);
            pruzateljUslugeFetched.setNazivPruzatelja(pruzateljUsluge.getNazivPruzatelja());
            pruzateljUslugaRepository.save(pruzateljUslugeFetched);
        } catch (Exception e) {
            System.out.println("Error while editing PruzateljUsluge: " + e.getMessage());
        }
    }

    public void deletePruzatelj(Long id) {
        /* Metoda za brisanje pruzatelja usluga. Prima id i brise PruzateljUsluga objekt **/
        try {
            pruzateljUslugaRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error while deleting PruzateljUsluge: " + e.getMessage());
        }
    }
}

