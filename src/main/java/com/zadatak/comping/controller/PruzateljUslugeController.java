package com.zadatak.comping.controller;

import com.zadatak.comping.entity.PruzateljUsluge;
import com.zadatak.comping.service.PruzateljUslugeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PruzateljUslugeController {

    @Autowired
    private PruzateljUslugeService pruzateljUslugeService;

    @PostMapping("/new-pruzatelj")
    public void addNewPruzatelj(@RequestBody PruzateljUsluge pruzateljUsluge){
        pruzateljUslugeService.addNewPruzatelj(pruzateljUsluge);
    }

    @PutMapping("/api/pruzateljiUsluga/{id}")
    public void editPruzatelja(@PathVariable Long id, @RequestBody PruzateljUsluge pruzateljUsluge){
        pruzateljUslugeService.editPruzatelj(id, pruzateljUsluge);
    }

    @DeleteMapping("/api/pruzateljiUsluga/{id}")
    public void deletePruzatelja(@PathVariable Long id){
        pruzateljUslugeService.deletePruzatelj(id);
    }
}
