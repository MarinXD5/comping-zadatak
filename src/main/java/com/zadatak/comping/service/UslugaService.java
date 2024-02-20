package com.zadatak.comping.service;

import com.zadatak.comping.entity.PruzateljUsluge;
import com.zadatak.comping.entity.Usluga;
import com.zadatak.comping.projections.UslugaOpisProjection;
import com.zadatak.comping.repository.PruzateljUslugaRepository;
import com.zadatak.comping.repository.UslugaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UslugaService {

    @Autowired
    UslugaRepository uslugaRepository;

    @Autowired
    PruzateljUslugaRepository pruzateljUslugaRepository;

    public void getOpisUsluga(){
        List<UslugaOpisProjection> opisUsluga = uslugaRepository.findAllOpisUsluge();

        for(UslugaOpisProjection projection: opisUsluga){
            System.out.println(projection.getOpisUsluga());
        }
    }

    public void addNewUsluga(Usluga usluga) {
        Usluga newUsluga = new Usluga();
        newUsluga.setOpisUsluge(usluga.getOpisUsluge());

        for (PruzateljUsluge pruzateljUsluge : usluga.getPruzateljiUsluge()) {
            Long id = pruzateljUsluge.getId();
            PruzateljUsluge pruzateljUslugeEntity = pruzateljUslugaRepository.findById(id).orElse(null);

            if (pruzateljUslugeEntity != null) {
                newUsluga.getPruzateljiUsluge().add(pruzateljUslugeEntity);
            }
        }
        uslugaRepository.save(newUsluga);
    }


    public void editUsluga(Long id, Usluga usluga){
        Usluga uslugaFetched = uslugaRepository.getReferenceById(id);
        uslugaFetched.setOpisUsluge(usluga.getOpisUsluge());
        uslugaRepository.save(uslugaFetched);
    }

    public void deleteUsluga(Long id) {
        uslugaRepository.deleteById(id);
    }
}