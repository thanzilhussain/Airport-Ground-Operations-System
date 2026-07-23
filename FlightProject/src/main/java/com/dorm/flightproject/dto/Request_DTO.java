package com.dorm.flightproject.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

import java.time.LocalDateTime;
@Data
public class Request_DTO {
    @NotBlank(message = "Flight Number is required")
    private String flightNumber;

    @NotBlank(message = "Airline name is required")
    private String airline;

    @NotNull(message = "Arrival Time is required")
    private LocalDateTime arrivalTime;

    @NotNull(message = "Departure Time is required")
    private LocalDateTime departureTime;

    @NotBlank(message = "Status is required")
    @Pattern(regexp = "(?i)Ready|Arrived|In_Process", message = "Only 'Ready, Arrived, In_Process' Status are allowed")
    private String status;

}
