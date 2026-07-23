package com.dorm.baggageproject.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Baggage")
public class Baggage {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long flightId;
    private Integer totalBags;
    private Integer loadedBags;
    private String status;
}