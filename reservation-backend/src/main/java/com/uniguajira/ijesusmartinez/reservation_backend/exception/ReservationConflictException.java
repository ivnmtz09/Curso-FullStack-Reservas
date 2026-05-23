package com.uniguajira.ijesusmartinez.reservation_backend.exception;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 * Exception thrown when attempting to create a reservation that conflicts 
 * with an existing active reservation at the same date and time.
 */
public class ReservationConflictException extends RuntimeException {
    
    public ReservationConflictException(LocalDate date, LocalTime time) {
        super("A reservation already exists for " + date + " at " + time);
    }
}
