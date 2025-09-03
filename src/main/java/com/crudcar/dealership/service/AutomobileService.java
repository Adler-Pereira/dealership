package com.crudcar.dealership.service;

import com.crudcar.dealership.entities.Automobile;
import com.crudcar.dealership.repository.AutomobileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class AutomobileService {

    @Autowired
    AutomobileRepository repository;

    public List<Automobile> listAll() {
        return repository.findAll();
    }

    public Optional<Automobile> findById(Long id) {
        return repository.findById(id);
    }

    public Automobile save(Automobile automobile) {
        return repository.save(automobile);
    }

    public Automobile update(Long id, Automobile newAutomobile) {
        return repository.findById(id)
                .map(automobile ->{
                    automobile.setChassiNumber(newAutomobile.getChassiNumber());
                    automobile.setManufacturer(newAutomobile.getManufacturer());
                    automobile.setModel(newAutomobile.getModel());
                    automobile.setYear(newAutomobile.getYear());
                    automobile.setColor(newAutomobile.getColor());
                    automobile.setKilometer(newAutomobile.getKilometer());
                    return repository.save(automobile);
                })
                .orElseThrow(() -> new RuntimeException("Automobile not found."));
    }

    public Automobile patch(Long id, Map<String, Object> updates) {
        return repository.findById(id)
                .map(automobile -> {
                    updates.forEach((key, value) -> {
                        switch (key) {
                            case "chassiNumber":
                                automobile.setChassiNumber((String) value);
                                break;
                            case "manufacturer":
                                automobile.setManufacturer((String) value);
                                break;
                            case "model":
                                automobile.setModel((String) value);
                                break;
                            case "year":
                                automobile.setYear(Integer.valueOf(String.valueOf(value)));
                                break;
                            case "color":
                                automobile.setColor((String) value);
                                break;
                            case "kilometer":
                                automobile.setKilometer(Long.valueOf(String.valueOf(value)));
                                break;
                        }
                    });
                    return repository.save(automobile);
                })
                .orElseThrow(() -> new RuntimeException("Automobile not found."));
    }


    public void delete(Long id) {
        repository.deleteById(id);
    }
}
