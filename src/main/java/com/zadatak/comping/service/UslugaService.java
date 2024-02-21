package com.zadatak.comping.service;

import com.zadatak.comping.entity.PruzateljUsluge;
import com.zadatak.comping.entity.Usluga;
import com.zadatak.comping.projections.UslugaOpisProjection;
import com.zadatak.comping.repository.PruzateljUslugaRepository;
import com.zadatak.comping.repository.UslugaRepository;
import com.zadatak.comping.specification.UslugaSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class UslugaService {

    @Autowired
    UslugaRepository uslugaRepository;

    @Autowired
    PruzateljUslugaRepository pruzateljUslugaRepository;

    public List<Usluga> getUsluge(Map<String, Object> properties){
        /* Metoda za filtriranje usluga po raznim propertijima. Prima listu propertija i nad njima vrsi querry findAll
        *  kako bi se profiltrirao rezultat po zadanim parametrima **/
        try{
            Specification<Usluga> specification = UslugaSpecification.hasProperties(properties);
            return uslugaRepository.findAll(specification);
        } catch(Exception e){
            System.out.println("Error while fetching filtered data: " + e.getMessage());
        }
        return null;
    }

    public List<String> getOpisUsluga() {
        /* Metoda za dohvaćanje opisa usluga koristenjem projekcija. **/
        try {
            List<UslugaOpisProjection> opisUsluga = uslugaRepository.findAllOpisUsluge();
            List<String> opisUslugaLista = new ArrayList<>();

            for (UslugaOpisProjection projection : opisUsluga) {
                opisUslugaLista.add(projection.getOpisUsluge());
            }
            return opisUslugaLista;
        } catch (Exception e) {
            System.out.println("Error while fetching opisUsluga: " + e.getMessage());
        }
        return null;
    }

    public void addNewUsluga(Usluga usluga) {
        /* Metoda za dodavanje nove usluge. Prima request body i kreira novi Usluga objekt te setira
        *  odgovarajuća polja. Lista pruzateljUslugeIds se sastoji od lista ID-ova koji se mapiraju prema idu pruzateljaUsluga
        * koji se zatim spremaju u međutablicu u bp **/
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
        /* Metoda za uređivanje Usluga objekta. Prima id i Usluga objekt **/
        try {
            Usluga uslugaFetched = uslugaRepository.getReferenceById(id);
            uslugaFetched.setOpisUsluge(usluga.getOpisUsluge());
            uslugaRepository.save(uslugaFetched);
        } catch (Exception e) {
            System.out.println("Error while editing usluga: " + e.getMessage());
        }
    }

    public void deleteUsluga(Long id) {
        /* Metoda za brisanje usluge. Prima id i brise Usluga objekt **/
        try {
            uslugaRepository.deleteById(id);
        } catch (Exception e) {
            System.out.println("Error while deleting usluga: " + e.getMessage());
        }
    }
}
