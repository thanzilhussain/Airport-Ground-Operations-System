package com.dorm.flightproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Response_DTO {
    private Long id;
    private String flightNumber;
    private String airline;
    private LocalDateTime arrivalTime;
    private LocalDateTime departureTime;
    private String status;
}
