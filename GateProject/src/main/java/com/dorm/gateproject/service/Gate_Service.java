package com.dorm.gateproject.service;

import com.dorm.gateproject.dto.Request_DTO;
import com.dorm.gateproject.dto.Response_DTO;
import com.dorm.gateproject.entity.Gate;
import com.dorm.gateproject.exception.GateNotFoundException;
import com.dorm.gateproject.exception.GateUnavailableException;
import com.dorm.gateproject.repository.Gate_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Gate_Service {
    @Autowired
    private Gate_Repo repo;

    public Response_DTO addGate(Request_DTO req){
        Gate gate= new Gate();
        gate.setGateName(req.getGateName());
        gate.setStatus(req.getStatus());
        gate.setTerminal(req.getTerminal());
        gate.setFlightId(req.getFlightId());
        repo.save(gate);
        Response_DTO res =new Response_DTO(gate.getId(),gate.getGateName(),gate.getTerminal(),gate.getStatus(),gate.getFlightId());
        return res;
    }
    public Response_DTO getGate(Long id){
        Gate gate=repo.findById(id).orElseThrow(()-> new GateNotFoundException("The Gate with the given ID is not Found"));
        Response_DTO res =new Response_DTO(gate.getId(),gate.getGateName(),gate.getTerminal(),gate.getStatus(),gate.getFlightId());
        return res;
    }

    public List<Gate> getAllGate(){
        return repo.findAll();
    }

    public Response_DTO updateGate(Long id,Request_DTO req){
        Gate oldgate=repo.findById(id).orElseThrow(()->new GateNotFoundException("The Gate with the given ID is not Found"));
        Gate gate = new Gate(oldgate.getId(),req.getGateName(),req.getTerminal(),req.getStatus(),req.getFlightId());
        repo.save(gate);
        repo.findById(id).orElseThrow(()->new GateNotFoundException("The Gate with the given ID is not Found"));
        Response_DTO res =new Response_DTO(gate.getId(),gate.getGateName(),gate.getTerminal(),gate.getStatus(),gate.getFlightId());
        return res;
    }

    public String deleteGate(Long id){
        Gate gate=repo.findById(id).orElseThrow(()-> new GateNotFoundException("The Gate with the given ID is not Found"));
        repo.deleteById(id);
        return "The Gate had been removed due to some Issues";
    }

    public String allocateGate(Long flightId) {
        Gate gate = repo.findFirstByStatusIgnoreCase("AVAILABLE").orElseThrow(() -> new GateUnavailableException("All gates are currently occupied!"));
        gate.setStatus("OCCUPIED");
        gate.setFlightId(flightId);
        repo.save(gate); // Save the state change
        return "Gate had been allocated for the flight with ID : " + flightId;
    }

    public String deAllocateGate(Long flightId) {
        Gate gate = repo.findByFlightId(flightId).orElseThrow(() -> new GateNotFoundException("No active gate found for this Flight ID"));
        gate.setStatus("AVAILABLE");
        gate.setFlightId(null);
        repo.save(gate);
        return "Gate had been deAllocated for the flight with ID : " + flightId;
    }
}
