package com.dorm.fuelproject.repository;


import com.dorm.fuelproject.entity.FuelRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Fuel_Repo extends JpaRepository<FuelRequest,Long> {
    Optional<FuelRequest> findFirstByStatus(String status);
    Optional<FuelRequest> findByFlightId(Long flightId);
}

