package com.dorm.gateproject.repository;


import com.dorm.gateproject.entity.Gate;
import jdk.jshell.Snippet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface Gate_Repo extends JpaRepository<Gate,Long> {
    Optional<Gate> findFirstByStatusIgnoreCase(String Status);
    Optional<Gate> findByFlightId(Long flightId);
}
