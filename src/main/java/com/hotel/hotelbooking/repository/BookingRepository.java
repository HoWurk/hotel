package com.hotel.hotelbooking.repository;


import com.hotel.hotelbooking.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    @Query("SELECT b FROM Booking b " +
            "WHERE (b.checkInDate BETWEEN :start_date AND :end_date) OR " +
            "      (b.checkOutDate BETWEEN :start_date AND :end_date) OR " +
            "      ((b.checkInDate <= :start_date) AND (b.checkOutDate >= :end_date))")
    List<Booking> findOverlappingBookings(
            @Param("start_date") LocalDateTime start_date,
            @Param("end_date") LocalDateTime end_date);

}
