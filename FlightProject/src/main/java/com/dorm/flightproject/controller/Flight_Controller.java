package com.dorm.flightproject.controller;

import com.dorm.flightproject.dto.Request_DTO;
import com.dorm.flightproject.dto.Response_DTO;
import com.dorm.flightproject.entity.Flight;
import com.dorm.flightproject.service.Flight_Service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/flights")
public class Flight_Controller {
    @Autowired
    private Flight_Service fsv;

    @PostMapping
    public Response_DTO addNewFlight(@Valid @RequestBody Request_DTO req){
        return fsv.addNewFlight(req);
    }

    @PutMapping("/ready/{id}")
    public String addnewdefaultFlight(@Valid @PathVariable Long id){
        return fsv.addnewdefaultFlight(id);
    }

    @GetMapping("/{id}")
    public Response_DTO getFlightDetailes(@PathVariable Long id){
        return fsv.getFlight(id);
    }

    @GetMapping
    public List<Flight> getAllFlightDetailes(){
        return fsv.getAllFlight();
    }

    @PutMapping("/{id}")
    public Response_DTO updateFlight(@PathVariable Long id,@Valid @RequestBody Request_DTO req){
        return fsv.updateFlight(id,req);
    }
    @DeleteMapping("/{id}")
    public String deleteFlight(@PathVariable Long id){
        return fsv.deleteFlight(id);
    }

}
