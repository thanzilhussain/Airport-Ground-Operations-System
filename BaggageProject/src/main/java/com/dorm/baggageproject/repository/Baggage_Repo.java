package com.dorm.baggageproject.repository;

import com.dorm.baggageproject.entity.Baggage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Baggage_Repo extends JpaRepository<Baggage,Long> {
}

