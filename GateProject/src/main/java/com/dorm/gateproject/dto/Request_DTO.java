package com.dorm.gateproject.dto;


import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class Request_DTO {
    @NotBlank(message = "Gate Name should not be blank")
    private String gateName;

    @NotBlank(message = "Terminal Name should not be blank")
    private String terminal;

    @NotBlank(message = "Status should not be blank")
    @Pattern(regexp = "(?i)OCCUPIED|AVAILABLE",message ="Only 'OCCUPIED and AVAILABLE' Status are allowed")
    private String status;

    private Long flightId;
}
