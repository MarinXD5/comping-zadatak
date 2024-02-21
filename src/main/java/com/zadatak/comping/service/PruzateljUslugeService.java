package com.zadatak.comping.service;

import com.zadatak.comping.entity.PruzateljUsluge;
import com.zadatak.comping.repository.PruzateljUslugaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PruzateljUslugeService {

    @Autowired
    private PruzateljUslugaRepository pruzateljUslugaRepository;

    public void addNewPruzatelj(PruzateljUsluge pruzateljUsluge) {
        try {
            pruzateljUslugaRepository.save(pruzateljUsluge);
        } catch (Exception e) {
            System.out.println("Error while adding new PruzateljUsluge: " + e.getMessage());
        }
    }

    public void editPruzatelj(Long id, PruzateljUsluge pruzateljUsluge) {
        try {
            PruzateljUsluge pruzateljUslugeFetched = pruzateljUslugaRepository.getReferenceById(id);
            pruzateljUslugeFetched.setNazivPruzatelja(pruzateljUsluge.getNazivPruzatelja());
            pruzateljUslugaRepository.save(pruzateljUslugeFetched);
        } catch (Exception e) {
            System.out.println("Error while editing PruzateljUsluge: " + e.getMessage());
        }
    }

    public void deletePruzatelj(Long id) {
        try {
            pruzateljUslugaRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error while deleting PruzateljUsluge: " + e.getMessage());
        }
    }
}

