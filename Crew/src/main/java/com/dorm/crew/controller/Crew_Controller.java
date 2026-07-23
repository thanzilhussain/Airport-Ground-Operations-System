package com.dorm.crew.controller;

import com.dorm.crew.dto.Request_DTO;
import com.dorm.crew.dto.Response_DTO;
import com.dorm.crew.entity.Crew;
import com.dorm.crew.service.Crew_Service;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/crew")
public class Crew_Controller {
    @Autowired
    private Crew_Service crs;

    @PostMapping
    public Response_DTO addCrew(@Valid @RequestBody Request_DTO req){
        return crs.addCrew(req);
    }

    @PutMapping("/{id}")
    public Response_DTO updateCrew(@PathVariable Long id, @Valid @RequestBody Request_DTO req){
        return crs.updateCrew(id,req);
    }

    @GetMapping("/{id}")
    public Response_DTO getCrew(@PathVariable Long id){
        return crs.getCrew(id);
    }

    @GetMapping
    public List<Crew> getAllCrew(){
        return crs.getAllCrew();
    }

    @DeleteMapping("/{id}")
    public String deleteCrew(@PathVariable Long id){
        return crs.deleteCrew(id);
    }

    @PutMapping("/assign/{id}")
    public String assignCrew(@PathVariable Long id, @RequestParam String specialization){
        return crs.assignCrew(id, specialization);
    }
    @PutMapping("/deassign/{id}")
    public String deassign(@PathVariable Long id,@RequestParam Long FlightId){
        return crs.deassign(id,FlightId);
    }

}
