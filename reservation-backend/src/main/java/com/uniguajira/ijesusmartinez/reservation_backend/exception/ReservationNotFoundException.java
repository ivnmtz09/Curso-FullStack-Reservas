package com.uniguajira.ijesusmartinez.reservation_backend.exception;

/**
 * Exception thrown when a reservation is not found by its identifier.
 */
public class ReservationNotFoundException extends RuntimeException {
    
    public ReservationNotFoundException(Long id) {
        super("Reservation with id " + id + " not found");
    }
}
