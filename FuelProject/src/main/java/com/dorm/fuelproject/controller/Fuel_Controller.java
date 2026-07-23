package com.dorm.fuelproject.controller;

import com.dorm.fuelproject.dto.Request_DTO;
import com.dorm.fuelproject.dto.Response_DTO;
import com.dorm.fuelproject.entity.FuelRequest;
import com.dorm.fuelproject.service.Fuel_Service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/fuel")
public class Fuel_Controller {
    @Autowired
    private Fuel_Service fls;

    @PostMapping("/add")
    public Response_DTO addFuel(@Valid @RequestBody Request_DTO req) {
        return fls.addFuel(req);
    }

    @PutMapping("/update/{id}")
    public Response_DTO updateFuel(@PathVariable Long id, @Valid @RequestBody Request_DTO req) {
        return fls.updateFuel(id, req);
    }

    @GetMapping("/all")
    public List<FuelRequest> getAllFuel() {
        return fls.getAllFuel();
    }

    @GetMapping("/{id}")
    public Response_DTO getFuel(@PathVariable Long id) {
        return fls.getFuel(id);
    }

    @DeleteMapping("/delete/{id}")
    public String deleteFuel(@PathVariable Long id) {
        return fls.deleteFuel(id);
    }

    @PutMapping("/request/{id}")
    public String request(@PathVariable Long id,@RequestParam Long quant,@RequestParam String status){
        return fls.request(id,quant,status);
    }

    @PutMapping("/complete/{id}")
    public String completed(@PathVariable Long id){
        return fls.completed(id);
    }

}
