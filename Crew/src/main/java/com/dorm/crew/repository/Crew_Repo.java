package com.dorm.crew.repository;

import com.dorm.crew.entity.Crew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface Crew_Repo extends JpaRepository<Crew,Long> {
    Optional<Crew> findFirstByAvailabilityAndSpecializationIgnoreCase(String availability,String specilization);
    Optional<Crew> findByIdAndFlightId(Long id, Long Flight_id);
}
