package com.dorm.operation.controller;
import com.dorm.operation.service.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/operations")
public class OperationController {
    @Autowired
    private OperationService os;


    @PostMapping("/{flightId}/status")
    public Map<String, String> startOperations(@PathVariable Long flightId) {
        return os.processArrival(flightId);
    }

}
