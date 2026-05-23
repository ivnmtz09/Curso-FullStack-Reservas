package com.uniguajira.ijesusmartinez.reservation_backend.mapper;

import org.springframework.stereotype.Component;

import com.uniguajira.ijesusmartinez.reservation_backend.dto.CreateReservationRequest;
import com.uniguajira.ijesusmartinez.reservation_backend.dto.ReservationResponse;
import com.uniguajira.ijesusmartinez.reservation_backend.entity.ReservationEntity;
import com.uniguajira.ijesusmartinez.reservation_backend.entity.ReservationStatus;

/**
 * Maps between entity and DTO objects for reservations.
 */
@Component
public class ReservationMapper {

    /**
     * Converts a create request to a reservation entity.
     *
     * @param request the creation request
     * @return a new entity with the request data and ACTIVE status
     */
    public ReservationEntity toEntity(CreateReservationRequest request) {
        ReservationEntity entity = new ReservationEntity();
        entity.setCustomerName(request.customerName());
        entity.setDate(request.date());
        entity.setTime(request.time());
        entity.setService(request.service());
        entity.setStatus(ReservationStatus.ACTIVE);
        return entity;
    }

    /**
     * Converts a reservation entity to a response DTO.
     *
     * @param entity the entity
     * @return a response containing the entity data
     */
    public ReservationResponse toResponse(ReservationEntity entity) {
        return new ReservationResponse(
                entity.getId(),
                entity.getCustomerName(),
                entity.getDate(),
                entity.getTime(),
                entity.getService(),
                entity.getStatus()
        );
    }
}
