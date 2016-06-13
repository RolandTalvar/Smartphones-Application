package com.rolandtalvar.service;

import com.rolandtalvar.model.Smartphone;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Created by rolandtalvar on 09/06/16.
 */
@Service
public class RestService {

    public List<Smartphone> getSmartphones() {
        RestTemplate restTemplate = new RestTemplate();
        List<Smartphone> smartphones = restTemplate.getForObject("http://localhost:8010/SmartphonesService/service/smartphones", List.class);
        return smartphones;
    }
}
