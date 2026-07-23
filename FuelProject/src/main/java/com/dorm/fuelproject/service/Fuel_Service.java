package com.dorm.fuelproject.service;

import com.dorm.fuelproject.dto.Request_DTO;
import com.dorm.fuelproject.dto.Response_DTO;
import com.dorm.fuelproject.entity.FuelRequest;
import com.dorm.fuelproject.exception.FlightNotFoundException;
import com.dorm.fuelproject.exception.FuelNotFoundException;
import com.dorm.fuelproject.repository.Fuel_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class Fuel_Service {
    @Autowired
    private Fuel_Repo repo;
    public Response_DTO addFuel(Request_DTO req) {
        FuelRequest fuel = new FuelRequest();
        fuel.setFlightId(req.getFlightId());
        fuel.setQuantity(req.getQuantity());
        fuel.setStatus(req.getStatus());
        repo.save(fuel);
        Response_DTO res = new Response_DTO(fuel.getId(), fuel.getFlightId(), fuel.getQuantity(), fuel.getStatus());
        return res;
    }

    public Response_DTO updateFuel(Long id, Request_DTO req) {
        FuelRequest fuel = repo.findById(id).orElseThrow(() -> new FuelNotFoundException("Fuel Request with the given ID is not found"));
        fuel.setFlightId(req.getFlightId());
        fuel.setQuantity(req.getQuantity());
        fuel.setStatus(req.getStatus());
        repo.save(fuel);
        Response_DTO res = new Response_DTO(fuel.getId(), fuel.getFlightId(), fuel.getQuantity(), fuel.getStatus());
        return res;
    }

    public List<FuelRequest> getAllFuel() {
        return repo.findAll();
    }

    public Response_DTO getFuel(Long id) {
        FuelRequest fuel = repo.findById(id).orElseThrow(() -> new FuelNotFoundException("Fuel Request with the given ID is not found"));
        Response_DTO res = new Response_DTO(fuel.getId(), fuel.getFlightId(), fuel.getQuantity(), fuel.getStatus());
        return res;
    }

    public String deleteFuel(Long id) {
        FuelRequest fuel = repo.findById(id).orElseThrow(() -> new FuelNotFoundException("Fuel Request with the given ID is not found"));
        repo.deleteById(id);
        return "The Fuel Request has been removed successfully";
    }

    public String request(Long id, Long quant, String status) {
        FuelRequest fuel = repo.findFirstByStatus("FREE").orElseThrow(() -> new FuelNotFoundException("No fuel station is currently free"));
        fuel.setFlightId(id);
        fuel.setQuantity(quant);
        fuel.setStatus("FUELING");
        repo.save(fuel);
        return "The Flight with ID : " + id + " is Currently Fueling";
    }
    public String completed(Long id){
        FuelRequest fuel=repo.findByFlightId(id).orElseThrow(() ->new FlightNotFoundException("Fuel Request cannot be freformed due to no available fuel station"));
        fuel.setFlightId(null);
        fuel.setStatus("FREE");
        fuel.setQuantity((long)2000);
        return "The Flight with ID : "+id+" had been fueled and fuel station with ID : "+fuel.getId()+"is free now";
    }

}
