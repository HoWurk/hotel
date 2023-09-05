package com.hotel.hotelbooking.repository;


import com.hotel.hotelbooking.entity.Booking;
import com.hotel.hotelbooking.entity.Room;
import com.hotel.hotelbooking.model.RoomDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

    @Query(value = "SELECT r FROM Room r " +
            "LEFT JOIN Booking b ON r.id = b.room.id     " +
            "WHERE " +
            "   (b.id IS NULL OR " +
            "   (" +
            "       (b.checkInDate NOT BETWEEN :start_date AND :end_date) " +
            "       AND (b.checkOutDate NOT BETWEEN :start_date AND :end_date) " +
            "       AND NOT (b.checkInDate <= :start_date AND b.checkOutDate >= :end_date) " +
            "   ))")
    List<Room> findOverlappingBookings(
            @Param("start_date") LocalDateTime startDate,
            @Param("end_date") LocalDateTime endDate);

}
