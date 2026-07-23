package com.dorm.flightproject.repository;


import com.dorm.flightproject.entity.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightRepo extends JpaRepository<Flight,Long> {
}

