package com.rolandtalvar.controller;

import com.rolandtalvar.model.Smartphone;
import com.rolandtalvar.repository.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/service")
public class ServicesController {

    @Autowired
    SmartphoneRepository smartphoneRepository;

    @RequestMapping(value = "/smartphones", method = RequestMethod.GET)
    public List<Smartphone> getDescription() {
        List<Smartphone> smartphones = smartphoneRepository.findAll();
        return smartphones;
    }

    @RequestMapping(value = "/smartphone/{id}", method = RequestMethod.GET)
    public Smartphone getDescription(@PathVariable("id") int id) {
        Smartphone smartphone = smartphoneRepository.findById(id);
        return smartphone;
    }

}
