package com.hotel.hotelbooking.controller;

import com.hotel.hotelbooking.model.BookingDTO;
import com.hotel.hotelbooking.model.RoomDTO;
import com.hotel.hotelbooking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    @GetMapping("/available")
    public ResponseEntity<List<RoomDTO>> getAvailableRooms(@RequestBody Map<String, LocalDateTime> dates) {
        LocalDateTime start_date = dates.get("start_date");
        LocalDateTime end_date = dates.get("end_date");
        List<RoomDTO> rooms = bookingService.getAvailableRooms(start_date, end_date);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO booking) {
        BookingDTO createdBooking = bookingService.createBooking(booking);
        return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
    }
}
