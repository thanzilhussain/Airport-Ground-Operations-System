package com.dorm.baggageproject.controller;


import com.dorm.baggageproject.service.Baggage_Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/baggage")
public class Baggage_Controller {
    @Autowired
    private Baggage_Service bas;

    @PostMapping("/load/{flight}")
    public String load(@PathVariable Long flight, @RequestParam Integer quant){
        return bas.load(flight,quant);
    }

    @PutMapping("/complete/{id}")
    public String complete(@PathVariable Long id){
        return bas.complete(id);
    }
}

