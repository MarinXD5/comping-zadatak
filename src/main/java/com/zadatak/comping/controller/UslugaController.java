package com.zadatak.comping.controller;

import com.zadatak.comping.entity.PruzateljUsluge;
import com.zadatak.comping.entity.Usluga;
import com.zadatak.comping.repository.UslugaRepository;
import com.zadatak.comping.service.UslugaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UslugaController {

    @Autowired
    UslugaService uslugaService;

    @Autowired
    UslugaRepository uslugaRepository;

    @GetMapping("/usluge")
    public List<Usluga> getUsluge(@RequestParam Map<String, Object> properties){
        return uslugaService.getUsluge(properties);
    }

    @GetMapping("/usluge/opisUsluga")
    public List<String> getOpisUsluga(){
        return uslugaService.getOpisUsluga();
    }

    @PostMapping("/new-usluga")
    public void addNewUsluga(@RequestBody Usluga usluga, @RequestBody PruzateljUsluge pruzateljUsluge) {
        uslugaService.addNewUsluga(usluga, pruzateljUsluge);
    }

    @PutMapping("/api/usluga/{id}")
    public void editUsluga(@PathVariable Long id, @RequestBody Usluga usluga) {
        uslugaService.editUsluga(id, usluga);
    }

    @DeleteMapping("/api/usluga/{id}")
    public void deleteUsluga(@PathVariable Long id){
        uslugaService.deleteUsluga(id);
    }
}
