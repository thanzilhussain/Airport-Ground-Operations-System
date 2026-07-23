package com.dorm.baggageproject.service;

import com.dorm.baggageproject.dto.Request_DTO;
import com.dorm.baggageproject.entity.Baggage;
import com.dorm.baggageproject.exceptions.BaggageException;
import com.dorm.baggageproject.repository.Baggage_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Baggage_Service {
    @Autowired
    private Baggage_Repo repo;

    public String load(Long id, Integer quantity){
        Request_DTO res=new Request_DTO();
        res.setFlightId(id);
        res.setTotalBags(quantity);
        res.setLoadedBags(0);
        res.setStatus("LOADING");
        Baggage bg=new Baggage();
        bg.setFlightId(res.getFlightId());
        bg.setLoadedBags(res.getLoadedBags());
        bg.setTotalBags(res.getTotalBags());
        bg.setStatus(res.getStatus());
        repo.save(bg);
        return "The baggage for the flight with ID : "+bg.getFlightId()+" is Loading";
    }

    public String complete(Long id){
        Baggage bg=repo.findById(id).orElseThrow(()->new BaggageException("Baggage id not Found"));
        bg.setStatus("COMPLETE");
        return "The baggage for the flight with ID : "+bg.getFlightId()+" is Loading";
    }

}
