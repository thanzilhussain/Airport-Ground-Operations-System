package com.dorm.gateproject.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Response_DTO {
    private Long id;

    private String gateName;

    private String terminal;

    private String status;

    private Long flightId;
}
