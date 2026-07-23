package com.dorm.crew.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Response_DTO {
    private Long id;

    private String crewName;

    private String specialization;

    private String availability;

    private Long flightId;
}

