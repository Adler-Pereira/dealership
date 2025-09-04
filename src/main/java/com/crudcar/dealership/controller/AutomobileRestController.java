package com.crudcar.dealership.controller;

import com.crudcar.dealership.entities.Automobile;
import com.crudcar.dealership.service.AutomobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/automobiles")
public class AutomobileRestController {

    @Autowired
    AutomobileService automobileService;

    @GetMapping
    public List<Automobile> listAll() {
        return automobileService.listAll();
    }

    @GetMapping("/{id}")
    public Optional<Automobile> findById(@PathVariable Long id) {
        return automobileService.findById(id);
    }


    @PostMapping
    public Automobile create(@RequestBody Automobile automobile) {
        return automobileService.save(automobile);
    }

    @PutMapping("/{id}")
    public Automobile update(@PathVariable Long id, @RequestBody Automobile automobile) {
        return automobileService.update(id, automobile);
    }

    @PatchMapping("/{id}")
    public Automobile patch(@PathVariable Long id, @RequestBody Map<String, Object> updates) {
        return automobileService.patch(id, updates);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        automobileService.delete(id);
    }
}
