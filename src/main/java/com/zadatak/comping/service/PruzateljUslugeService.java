package com.zadatak.comping.service;

import com.zadatak.comping.entity.PruzateljUsluge;
import com.zadatak.comping.repository.PruzateljUslugaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PruzateljUslugeService {

    @Autowired
    private PruzateljUslugaRepository pruzateljUslugaRepository;

    public void addNewPruzatelj(PruzateljUsluge pruzateljUsluge){
        pruzateljUslugaRepository.save(pruzateljUsluge);
    }

    public void editPruzatelj(Long id, PruzateljUsluge pruzateljUsluge){
        PruzateljUsluge pruzateljUslugeFetched = pruzateljUslugaRepository.getReferenceById(id);
        pruzateljUslugeFetched.setNazivPruzatelja(pruzateljUsluge.getNazivPruzatelja());
        pruzateljUslugaRepository.save(pruzateljUslugeFetched);
    }

    public void deletePruzatelj(Long id){
        pruzateljUslugaRepository.deleteById(id);
    }
}
