package com.dorm.gateproject.controller;

import com.dorm.gateproject.dto.Request_DTO;
import com.dorm.gateproject.dto.Response_DTO;
import com.dorm.gateproject.entity.Gate;
import com.dorm.gateproject.service.Gate_Service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gates")
public class Gate_Controller {
    @Autowired
    private Gate_Service gsv;

    @PostMapping
    public Response_DTO addGate(@Valid @RequestBody Request_DTO req){
        return gsv.addGate(req);
    }

    @PutMapping("/{id}")
    public Response_DTO updateGate(@PathVariable Long id,@Valid @RequestBody Request_DTO req){
        return gsv.updateGate(id,req);
    }
    @GetMapping
    public List<Gate> getAllGate(){
        return gsv.getAllGate();
    }

    @GetMapping("/{id}")
    public Response_DTO getGateDetailes(@PathVariable Long id){
        return gsv.getGate(id);
    }

    @DeleteMapping("/{id}")
    public String deleteGate(@PathVariable Long id){
        return gsv.deleteGate(id);
    }

    @PutMapping("/allocate")
    public String allocateGate(@RequestParam Long id){
        return gsv.allocateGate(id);
    }

    @PutMapping("/deallocate")
    public String deallocate(@RequestParam Long id){
        return gsv.deAllocateGate(id);
    }
}
