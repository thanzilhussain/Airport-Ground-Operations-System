package com.dorm.flightproject.service;

import com.dorm.flightproject.dto.Request_DTO;
import com.dorm.flightproject.dto.Response_DTO;
import com.dorm.flightproject.entity.Flight;
import com.dorm.flightproject.exceptions.FlightNotFoundException;
import com.dorm.flightproject.repository.FlightRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class Flight_Service {
    @Autowired
    private FlightRepo repo;

    public Response_DTO addNewFlight(Request_DTO req) {
        Flight flight = new Flight();
        flight.setFlightNumber(req.getFlightNumber());
        flight.setAirline(req.getAirline());
        flight.setArrivalTime(req.getArrivalTime());
        flight.setDepartureTime(req.getDepartureTime());
        flight.setStatus(req.getStatus());
        repo.save(flight);
        Response_DTO res =new Response_DTO(flight.getId(),flight.getFlightNumber(),flight.getAirline(),flight.getArrivalTime(),flight.getDepartureTime(),flight.getStatus());
        return res;
    }
    public String addnewdefaultFlight(Long id){
        Flight oldfli=repo.findById(id).orElseThrow(()->new FlightNotFoundException("The Flight with the given ID is not Found"));
        Flight flight = new Flight(oldfli.getId(),oldfli.getFlightNumber(),oldfli.getAirline(), LocalDateTime.now(),LocalDateTime.now().plusHours(5),"Arrived");
        repo.save(flight);
        return "Flight with Flight Number : "+flight.getFlightNumber() +"Is Arrived and waiting for further opperations";
    }

    public Response_DTO getFlight(Long id){
        Flight flight=repo.findById(id).orElseThrow(()-> new FlightNotFoundException("The Flight with the given ID is not Found"));
        Response_DTO res =new Response_DTO(flight.getId(),flight.getFlightNumber(),flight.getAirline(),flight.getArrivalTime(),flight.getDepartureTime(),flight.getStatus());
        return res;
    }

    public List<Flight> getAllFlight(){
        return repo.findAll();
    }

    public Response_DTO updateFlight(Long id,Request_DTO req){
        Flight oldfli=repo.findById(id).orElseThrow(()->new FlightNotFoundException("The Flight with the given ID is not Found"));
        Flight flight = new Flight(oldfli.getId(),req.getFlightNumber(),req.getAirline(),req.getArrivalTime(),req.getDepartureTime(),req.getStatus());
        repo.save(flight);
        Response_DTO res =new Response_DTO(flight.getId(),flight.getFlightNumber(),flight.getAirline(),flight.getArrivalTime(),flight.getDepartureTime(),flight.getStatus());
        return res;
    }

    public String deleteFlight(Long id){
        Flight flight =repo.findById(id).orElseThrow(()->new FlightNotFoundException("The Flight with the given ID is not Found"));
        repo.deleteById(id);
        return "The Flight had been removed due to some Issues";
    }
}
