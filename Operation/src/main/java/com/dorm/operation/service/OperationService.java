package com.dorm.operation.service;
import com.dorm.operation.dto.RequestDto;
import com.dorm.operation.exception.*;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class OperationService {
    private final RestTemplate restTemplate;

    private final String flightUrl = "http://localhost:8081/api/v1/flights";
    private final String gateUrl = "http://localhost:8082/api/v1/gates";
    private final String crewUrl = "http://localhost:8083/api/v1/crew";
    private final String fuelUrl = "http://localhost:8084/api/v1/fuel";
    private final String baggageUrl = "http://localhost:8085/api/v1/baggage";

    public OperationService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Map<String, String> processArrival(Long flightId ) {
        Map<String, String> response = new LinkedHashMap<>();
        try {
            String flightres = restTemplate.exchange(flightUrl + "/ready/"+flightId, HttpMethod.PUT, null, String.class).getBody();
            response.put("flight", flightres);
        } catch (Exception e) {
            throw new FlightNotFoundException("Failed to register flight: " + e.getMessage());
        }
        try {
            String gateRes = restTemplate.exchange(gateUrl + "/allocate?id=" + flightId, HttpMethod.PUT, null, String.class).getBody();
            response.put("gate", gateRes);
        } catch (Exception e) {
            throw new GateUnavailable("Gate allocation failed for flight " + flightId);
        }

        try {
            String bagRes = restTemplate.exchange(crewUrl + "/assign/" + flightId + "?specialization=BAGGAGE", HttpMethod.PUT, null, String.class).getBody();
            response.put("baggageCrew", bagRes);
        } catch (Exception e) {
            throw new CrewUnavailable("Baggage crew assignment failed.");
        }

        try {
            String fuelCrewRes = restTemplate.exchange(crewUrl + "/assign/" + flightId + "?specialization=FUELING", HttpMethod.PUT, null, String.class).getBody();
            response.put("fuelCrew", fuelCrewRes);
        } catch (Exception e) {
            throw new CrewUnavailable("Fueling crew assignment failed.");
        }
        try {
            String fuelRes = restTemplate.exchange(fuelUrl + "/request/" + flightId + "?quant=5000&status=AVAILABLE", HttpMethod.PUT, null, String.class).getBody();
            response.put("fueling", fuelRes);
        } catch (Exception e) {
            throw new FuelRequestNotFoundException("Fueling request failed: " + e.getMessage());
        }
        try{
            String baggageRes = restTemplate.exchange(baggageUrl + "/load/" + flightId + "?quant=5000", HttpMethod.POST, null, String.class).getBody();
            response.put("baggage", baggageRes);
        }
        catch (Exception e){
            throw new BaggageException("Baggage id not found"+e.getMessage());
        }
        response.put("overallStatus", "READY FOR DEPARTURE");
        return response;
    }

}
