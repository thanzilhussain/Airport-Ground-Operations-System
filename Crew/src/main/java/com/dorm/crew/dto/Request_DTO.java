package com.dorm.crew.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data

public class Request_DTO {

    @NotBlank(message = "Crew Name should not be blank")
    private String crewName;

    @NotBlank(message = "Specialization should not be blank")
    @Pattern(regexp = "(i?)BAGGAGE|FUELING",message = "Only BAGGAGE and FUELING are allowed")
    private String specialization;

    @NotBlank(message = "availability should not be blank")
    @Pattern(regexp = "(i?)AVAILABLE|BUSY",message = "Only AVAILABLE and BUSY are allowed")
    private String availability;

    private Long flightId;
}

