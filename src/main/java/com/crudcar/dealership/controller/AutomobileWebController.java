package com.crudcar.dealership.controller;

import com.crudcar.dealership.entities.Automobile;
import com.crudcar.dealership.service.AutomobileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/automobiles")
public class AutomobileWebController {

    @Autowired
    AutomobileService automobileService;

    @GetMapping("/new")
    public String newAuto(Model model) {
        model.addAttribute("automobile", new Automobile());
        return "automobiles/new";
    }

    @PostMapping("/new")
    public String saveAuto(Automobile automobile) {
        automobileService.save(automobile);
        return "redirect:/automobiles/list";
    }

    @GetMapping("/list")
    public String listAuto(Model model) {
        List<Automobile> listAutomobile = automobileService.listAll();
        model.addAttribute("listAuto", listAutomobile);
        return "automobiles/list";
    }
}
