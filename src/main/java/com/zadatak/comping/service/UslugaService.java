package com.zadatak.comping.service;

import com.zadatak.comping.entity.PruzateljUsluge;
import com.zadatak.comping.entity.Usluga;
import com.zadatak.comping.projections.UslugaOpisProjection;
import com.zadatak.comping.repository.PruzateljUslugaRepository;
import com.zadatak.comping.repository.UslugaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UslugaService {

    @Autowired
    UslugaRepository uslugaRepository;

    @Autowired
    PruzateljUslugaRepository pruzateljUslugaRepository;

    public void getOpisUsluga() {
        try {
            List<UslugaOpisProjection> opisUsluga = uslugaRepository.findAllOpisUsluge();

            for (UslugaOpisProjection projection : opisUsluga) {
                System.out.println(projection.getOpisUsluge());
            }
        } catch (Exception e) {
            System.out.println("Error while fetching opisUsluga: " + e.getMessage());
        }
    }

    public void addNewUsluga(Usluga usluga) {
        try {
            Usluga newUsluga = new Usluga();
            newUsluga.setOpisUsluge(usluga.getOpisUsluge());

            List<Long> pruzateljUslugeIds = usluga.getPruzateljiUsluge().stream()
                    .map(PruzateljUsluge::getId)
                    .collect(Collectors.toList());

            List<PruzateljUsluge> pruzateljiUslugeEntities = pruzateljUslugaRepository.findAllById(pruzateljUslugeIds);

            newUsluga.getPruzateljiUsluge().addAll(pruzateljiUslugeEntities);

            uslugaRepository.save(newUsluga);
        } catch (Exception e) {
            System.out.println("Error while adding new usluga: " + e.getMessage());
        }
    }

    public void editUsluga(Long id, Usluga usluga) {
        try {
            Usluga uslugaFetched = uslugaRepository.getReferenceById(id);
            uslugaFetched.setOpisUsluge(usluga.getOpisUsluge());
            uslugaRepository.save(uslugaFetched);
        } catch (Exception e) {
            System.out.println("Error while editing usluga: " + e.getMessage());
        }
    }

    public void deleteUsluga(Long id) {
        try {
            uslugaRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error while deleting usluga: " + e.getMessage());
        }
    }
}
