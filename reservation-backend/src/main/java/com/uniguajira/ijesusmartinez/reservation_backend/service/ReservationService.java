package com.uniguajira.ijesusmartinez.reservation_backend.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.uniguajira.ijesusmartinez.reservation_backend.dto.CreateReservationRequest;
import com.uniguajira.ijesusmartinez.reservation_backend.dto.ReservationResponse;
import com.uniguajira.ijesusmartinez.reservation_backend.entity.ReservationStatus;
import com.uniguajira.ijesusmartinez.reservation_backend.exception.ReservationAlreadyCancelledException;
import com.uniguajira.ijesusmartinez.reservation_backend.exception.ReservationConflictException;
import com.uniguajira.ijesusmartinez.reservation_backend.exception.ReservationNotFoundException;
import com.uniguajira.ijesusmartinez.reservation_backend.mapper.ReservationMapper;
import com.uniguajira.ijesusmartinez.reservation_backend.repository.ReservationRepository;

/**
 * Application service for reservation business operations.
 */
@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final ReservationMapper reservationMapper;

    /**
     * Creates the service with required dependencies.
     *
     * @param reservationRepository data access for reservations
     * @param reservationMapper     entity and DTO mapper
     */
    public ReservationService(
            ReservationRepository reservationRepository,
            ReservationMapper reservationMapper) {
        this.reservationRepository = reservationRepository;
        this.reservationMapper = reservationMapper;
    }

    /**
     * Creates a reservation when no other active reservation exists for the same date and time.
     *
     * @param request reservation data to create
     * @return the created reservation representation
     * @throws ReservationConflictException if an active reservation already occupies the slot
     */
    @Transactional
    public ReservationResponse createReservation(CreateReservationRequest request) {
        if (reservationRepository.existsByDateAndTimeAndStatus(
                request.date(), request.time(), ReservationStatus.ACTIVE)) {
            throw new ReservationConflictException(request.date(), request.time());
        }

        var entity = reservationMapper.toEntity(request);
        var saved = reservationRepository.save(entity);
        return reservationMapper.toResponse(saved);
    }

    /**
     * Cancels an existing reservation by its identifier.
     *
     * @param id reservation identifier
     * @return the cancelled reservation representation
     * @throws ReservationNotFoundException         if no reservation exists with the given id
     * @throws ReservationAlreadyCancelledException if the reservation is already cancelled
     */
    @Transactional
    public ReservationResponse cancelReservation(Long id) {
        var entity = reservationRepository.findById(id)
                .orElseThrow(() -> new ReservationNotFoundException(id));

        if (entity.getStatus() == ReservationStatus.CANCELLED) {
            throw new ReservationAlreadyCancelledException(id);
        }

        entity.setStatus(ReservationStatus.CANCELLED);
        var saved = reservationRepository.save(entity);
        return reservationMapper.toResponse(saved);
    }

    /**
     * Retrieves all reservations.
     *
     * @return list of reservation responses
     */
    @Transactional(readOnly = true)
    public List<ReservationResponse> getAllReservations() {
        return reservationRepository.findAll()
                .stream()
                .map(reservationMapper::toResponse)
                .toList();
    }
}
