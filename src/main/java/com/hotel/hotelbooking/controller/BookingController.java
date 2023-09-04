package com.hotel.hotelbooking.controller;

import com.hotel.hotelbooking.model.BookingDTO;
import com.hotel.hotelbooking.model.DateTimeSpan;
import com.hotel.hotelbooking.model.RoomDTO;
import com.hotel.hotelbooking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bookings")
public class BookingController {

    private final BookingService bookingService;

    @PostMapping("/available")
    public ResponseEntity<List<RoomDTO>> getAvailableRooms(@RequestBody DateTimeSpan span) {
        List<RoomDTO> rooms = bookingService.getAvailableRooms(span);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO booking) {
        BookingDTO createdBooking = bookingService.createBooking(booking);
        return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
    }
}
