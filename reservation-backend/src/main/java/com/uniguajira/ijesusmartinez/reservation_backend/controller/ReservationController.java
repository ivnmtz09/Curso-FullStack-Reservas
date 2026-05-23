package com.uniguajira.ijesusmartinez.reservation_backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uniguajira.ijesusmartinez.reservation_backend.dto.CreateReservationRequest;
import com.uniguajira.ijesusmartinez.reservation_backend.dto.ReservationResponse;
import com.uniguajira.ijesusmartinez.reservation_backend.service.ReservationService;

/**
 * REST controller for managing reservations.
 */
@RestController
@RequestMapping("/api/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    /**
     * Creates the controller with required dependencies.
     *
     * @param reservationService service for reservation operations
     */
    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }

    /**
     * Creates a new reservation.
     *
     * @param request reservation creation data
     * @return the created reservation
     */
    @PostMapping
    public ResponseEntity<ReservationResponse> createReservation(@RequestBody CreateReservationRequest request) {
        ReservationResponse response = reservationService.createReservation(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    /**
     * Cancels an existing reservation.
     *
     * @param id the reservation identifier
     * @return the cancelled reservation
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<ReservationResponse> cancelReservation(@PathVariable Long id) {
        ReservationResponse response = reservationService.cancelReservation(id);
        return ResponseEntity.ok(response);
    }
}
