package com.dorm.fuelproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response_DTO {
    private Long id;

    private Long flightId;

    private Long quantity;

    private String status;
}
