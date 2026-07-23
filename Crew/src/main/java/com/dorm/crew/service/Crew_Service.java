package com.dorm.crew.service;


import com.dorm.crew.dto.Request_DTO;
import com.dorm.crew.dto.Response_DTO;
import com.dorm.crew.entity.Crew;
import com.dorm.crew.exception.CrewNotFoundException;
import com.dorm.crew.exception.CrewUnavailableException;
import com.dorm.crew.repository.Crew_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.core.RepositoryMetadata;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class Crew_Service {
    @Autowired
    private Crew_Repo repo;

    public Response_DTO addCrew(Request_DTO req){
        Crew crew = new Crew();
        crew.setCrewName(req.getCrewName());
        crew.setSpecialization(req.getSpecialization());
        crew.setAvailability(req.getAvailability());
        crew.setFlightId(req.getFlightId());
        repo.save(crew);
        Response_DTO res =new Response_DTO(crew.getId(),crew.getCrewName(),crew.getSpecialization(),crew.getAvailability(),crew.getFlightId());
        return res;
    }
    public Response_DTO updateCrew(@PathVariable Long id, @RequestBody Request_DTO req){
        Crew crew = repo.findById(id).orElseThrow(() -> new CrewNotFoundException("The Crew with the given ID is not Found"));
        Response_DTO res =new Response_DTO(crew.getId(),crew.getCrewName(),crew.getSpecialization(),crew.getAvailability(),crew.getFlightId());
        return res;
    }

    public List<Crew> getAllCrew(){
        return repo.findAll();
    }

    public Response_DTO getCrew(@PathVariable Long id){
        Crew crew=repo.findById(id).orElseThrow(()->new CrewNotFoundException("Crew with the given Id is not found"));
        Response_DTO res =new Response_DTO(crew.getId(),crew.getCrewName(),crew.getSpecialization(),crew.getAvailability(),crew.getFlightId());
        return res;
    }
    public String deleteCrew(@PathVariable Long id){
        Crew crew=repo.findById(id).orElseThrow(()->new CrewNotFoundException("Crew with the given Id is not found"));
        repo.deleteById(id);
        return "The Crew had been removed due to some Reason";
    }

    public String assignCrew(Long id,String  specialization){
        Crew crew = repo.findFirstByAvailabilityAndSpecializationIgnoreCase("AVAILABLE", specialization).orElseThrow(() -> new CrewUnavailableException("No crew member is currently AVAILABLE with that specialization"));
        crew.setAvailability("BUSY");
        crew.setFlightId(id);
        repo.save(crew);
        return "The Crew : " + crew.getCrewName() + " with Specialization : " + crew.getSpecialization() + " has been assigned for flight with ID : " + id;
    }
    public String deassign(Long crewId, Long flightId) {
        Crew crew = repo.findByIdAndFlightId(crewId, flightId) .orElseThrow(() -> new CrewNotFoundException("Crew not found assigned to this flight"));
        crew.setAvailability("AVAILABLE");
        crew.setFlightId(null);
        repo.save(crew);
        return "The Crew : "+crew.getCrewName() +" has been deassigned";
    }
}
