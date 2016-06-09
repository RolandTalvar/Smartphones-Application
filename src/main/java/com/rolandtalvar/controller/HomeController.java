package com.rolandtalvar.controller;


import com.rolandtalvar.model.Smartphone;
import com.rolandtalvar.repository.SmartphoneRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.PostConstruct;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/smartphone")
public class HomeController {

    @Autowired
    SmartphoneRepository smartphoneRepository;

    private static final Logger logger = LoggerFactory.getLogger("smartphoneLogger");

    @PostConstruct
    public void init() {
        logger.info("Homecontroller init");
    }

    @RequestMapping(value = "/s", method = RequestMethod.GET)
    public String smartphones(Model model) {
        logger.info("Getting list of smartphones...");
        List<Smartphone> smartphones = smartphoneRepository.findAllByOrderByIdAsc();
        model.addAttribute(smartphones);
        return "smartphones";
    }

    @RequestMapping(value = "/s", method = RequestMethod.GET, params = "id")
    public String smartphone(@RequestParam("id") int id, Model model) {
        logger.info("Requesting smartphone of id: " + id);
        Smartphone smartphone = smartphoneRepository.findById(id);
        if (smartphone == null) {
            model.addAttribute("id", id);
            return "errorNoID";
        }
        model.addAttribute(smartphone);
        return "smartphone";
    }

    @RequestMapping(value = "/s", method= RequestMethod.POST, params = "action")
    public String saveSmartphone(@Valid @ModelAttribute Smartphone smartphone, BindingResult bindingResult) {
        logger.info("Saving smartphone...");

        if (bindingResult.hasErrors()) {
            return "smartphone";
        }

        smartphoneRepository.save(smartphone);
        return "redirect:/smartphone/s";
    }


}
