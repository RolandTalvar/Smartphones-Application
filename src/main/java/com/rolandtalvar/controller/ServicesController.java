package com.rolandtalvar.controller;

import com.rolandtalvar.model.Smartphone;
import com.rolandtalvar.repository.SmartphoneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.google.gson.Gson;


@RestController
@RequestMapping("/smartphone")
public class ServicesController {

    @Autowired
    SmartphoneRepository smartphoneRepository;

    @RequestMapping(value = "/smartphoneservice", method = RequestMethod.GET, params = "id")
    public Smartphone getDescription(@RequestParam("id") int id) {
        Smartphone smartphone = smartphoneRepository.findById(id);
        return smartphone;
    }

}
