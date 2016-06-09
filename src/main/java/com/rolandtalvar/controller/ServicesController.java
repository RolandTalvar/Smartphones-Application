package com.rolandtalvar.controller;

import com.rolandtalvar.model.Smartphone;
import com.rolandtalvar.repository.SmartphoneRepository;
import com.rolandtalvar.repository.SmartphoneSearchDAO;
import com.rolandtalvar.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/service")
public class ServicesController {

    @Autowired
    SmartphoneRepository smartphoneRepository;

    @Autowired
    SmartphoneSearchDAO smartphoneSearchDAO;

    @Autowired
    RestService restService;

    @RequestMapping(value = "/smartphones", method = RequestMethod.GET)
    public List<Smartphone> getSmartphones() {
        List<Smartphone> smartphones = smartphoneRepository.findAll();
        return smartphones;
    }

    @RequestMapping(value = "/smartphones/{id}", method = RequestMethod.GET)
    public Smartphone getSmartphone(@PathVariable("id") long id) {
        Smartphone smartphone = smartphoneRepository.findById(id);
        return smartphone;
    }

    @RequestMapping(value = "/smartphones", method = RequestMethod.POST)
    public void createSmartphone(@RequestBody Smartphone smartphone) {
        smartphoneRepository.save(smartphone);
    }

    @RequestMapping(value = "/smartphones/{id}", method = RequestMethod.PUT)
    public void updateSmartphone(@PathVariable("id") long id, @RequestBody Smartphone smartphone) {
        smartphone.setId(id);
        smartphoneRepository.save(smartphone);
    }

    @RequestMapping(value = "/smartphones/{id}", method = RequestMethod.DELETE)
    public void deleteSmartphone(@PathVariable("id") long id) {
        smartphoneRepository.delete(id);
    }

    @RequestMapping(value = "/external/smartphones", method = RequestMethod.GET)
    public List<Smartphone> getExternalSmartphones() {
        return restService.getSmartphones();
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public List<Smartphone> searchSmartphones(@RequestParam(required = false, value = "manufacturer") String manufacturer,
                                              @RequestParam(required = false, value = "model") String model,
                                              @RequestParam(required = false, value = "price") Integer price,
                                              @RequestParam(required = false, value = "description") String description) {
        List<Smartphone> smartphones = smartphoneSearchDAO.searchByModel(manufacturer, model, price, description);
        return smartphones;
    }

}
