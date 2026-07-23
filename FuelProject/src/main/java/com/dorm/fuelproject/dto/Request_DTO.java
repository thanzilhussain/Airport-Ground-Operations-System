package com.dorm.fuelproject.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.NotNull;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Request_DTO {
    private Long flightId;


    private Long quantity;

    @NotBlank(message = "The Status should not be Blank")
    @Pattern(regexp = "(i?)FUELING|FREE")
    private String status;
}

