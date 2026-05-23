package com.uniguajira.ijesusmartinez.reservation_backend.repository;

import java.time.LocalDate;
import java.time.LocalTime;

import org.springframework.data.jpa.repository.JpaRepository;

import com.uniguajira.ijesusmartinez.reservation_backend.entity.ReservationEntity;
import com.uniguajira.ijesusmartinez.reservation_backend.entity.ReservationStatus;

public interface ReservationRepository extends JpaRepository<ReservationEntity, Long> {

    /**
     * Checks whether a reservation exists for the given date, time and status.
     *
     * @param date   reservation date
     * @param time   reservation time
     * @param status reservation status to match
     * @return {@code true} if a matching reservation exists
     */
    boolean existsByDateAndTimeAndStatus(LocalDate date, LocalTime time, ReservationStatus status);

}
