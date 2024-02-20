package com.zadatak.comping.controller;

import com.zadatak.comping.entity.Usluga;
import com.zadatak.comping.repository.UslugaRepository;
import com.zadatak.comping.service.UslugaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UslugaController {

    @Autowired
    UslugaService uslugaService;

    @Autowired
    UslugaRepository uslugaRepository;

    @GetMapping("/usluge/opisUsluga")
    public void getOpisUsluga(){
        uslugaService.getOpisUsluga();
    }

    @PostMapping("/new-usluga")
    public void addNewUsluga(@RequestBody Usluga usluga) {
        uslugaService.addNewUsluga(usluga);
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
