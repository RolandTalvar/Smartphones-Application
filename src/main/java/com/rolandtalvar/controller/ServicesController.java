package com.rolandtalvar.controller;

import com.rolandtalvar.model.Smartphone;
import com.rolandtalvar.repository.SmartphoneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/service")
public class ServicesController {

    @Autowired
    SmartphoneRepository smartphoneRepository;

    @RequestMapping(value = "/smartphone", method = RequestMethod.GET, params = "id")
    public Smartphone getDescription(@RequestParam("id") int id) {
        Smartphone smartphone = smartphoneRepository.findById(id);
        return smartphone;
    }

}
