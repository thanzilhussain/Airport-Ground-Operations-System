package com.dorm.operation.exception;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest request) {
        ErrorResponse response=new ErrorResponse(HttpStatus.BAD_REQUEST.value(),HttpStatus.BAD_REQUEST.getReasonPhrase(),ex.getMessage(), LocalDateTime.now(), request.getRequestURI());
        return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(FlightNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleFlightNotFound(FlightNotFoundException ex, HttpServletRequest request) {
        ErrorResponse response = new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE.value(), "Flight Service Unavailable", ex.getMessage(), LocalDateTime.now(), request.getRequestURI());
        return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
    }

    @ExceptionHandler(CrewUnavailable.class)
    public ResponseEntity<ErrorResponse> handleCrewUnavailable(CrewUnavailable ex, HttpServletRequest request) {
        ErrorResponse response = new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE.value(), "Flight Service Unavailable", ex.getMessage(), LocalDateTime.now(), request.getRequestURI());
        return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
    }
    @ExceptionHandler(GateUnavailable.class)
    public ResponseEntity<ErrorResponse> handleGateUnavailable(GateUnavailable ex, HttpServletRequest request) {
        ErrorResponse response = new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE.value(), "Flight Service Unavailable", ex.getMessage(), LocalDateTime.now(), request.getRequestURI());
        return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
    }
    @ExceptionHandler(FuelRequestNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleFuelRequestNotFound(FuelRequestNotFoundException ex, HttpServletRequest request) {
        ErrorResponse response = new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE.value(), "Flight Service Unavailable", ex.getMessage(), LocalDateTime.now(), request.getRequestURI());
        return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
    }
    @ExceptionHandler(BaggageException.class)
    public ResponseEntity<ErrorResponse> handleBaggage(BaggageException ex, HttpServletRequest request) {
        ErrorResponse response = new ErrorResponse(HttpStatus.SERVICE_UNAVAILABLE.value(), "Flight Service Unavailable", ex.getMessage(), LocalDateTime.now(), request.getRequestURI());
        return new ResponseEntity<>(response, HttpStatus.SERVICE_UNAVAILABLE);
    }


}
