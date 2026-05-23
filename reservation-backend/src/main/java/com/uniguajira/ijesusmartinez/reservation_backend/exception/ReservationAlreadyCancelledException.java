package com.uniguajira.ijesusmartinez.reservation_backend.exception;

/**
 * Exception thrown when attempting to cancel a reservation that is already cancelled.
 */
public class ReservationAlreadyCancelledException extends RuntimeException {
    
    public ReservationAlreadyCancelledException(Long id) {
        super("Reservation with id " + id + " is already cancelled");
    }
}
