package com.hotel.hotelbooking.controller;

import com.hotel.hotelbooking.model.BookingDTO;
import com.hotel.hotelbooking.model.DateTimeRequest;
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

    private final BookingService bookingServiceImpl;
    private final BookingService bookingMockService;

    @PostMapping("/available")
    public ResponseEntity<List<RoomDTO>> getAvailableRooms(@RequestBody DateTimeRequest request) {
        DateTimeSpan dateTimeSpan = request.getDateTimeSpan();
        List<RoomDTO> rooms = bookingServiceImpl.getAvailableRooms(dateTimeSpan);
        return new ResponseEntity<>(rooms, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BookingDTO> createBooking(@RequestBody BookingDTO booking) {
        BookingDTO createdBooking = bookingMockService.createBooking(booking);
        return new ResponseEntity<>(createdBooking, HttpStatus.CREATED);
    }
}
