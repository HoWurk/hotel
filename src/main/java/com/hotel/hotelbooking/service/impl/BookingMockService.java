package com.hotel.hotelbooking.service.impl;

import com.hotel.hotelbooking.model.BookingDTO;
import com.hotel.hotelbooking.model.DateTimeSpan;
import com.hotel.hotelbooking.model.RoomDTO;
import com.hotel.hotelbooking.service.BookingService;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

//@Service
public class BookingMockService implements BookingService {

    @Override
    public List<RoomDTO> getAvailableRooms(DateTimeSpan span) {
        return roomExamples();
    }

    @Override
    public BookingDTO createBooking(BookingDTO booking) {
        return BookingDTO.builder()
                .roomId(1)
                .checkInDate(LocalDateTime.of(2020, 10, 9, 8, 7))
                .checkOutDate(LocalDateTime.of(2020, 11, 9, 8, 7))
                .guestsAmount(3)
                .guestsInfo("Family")
                .creationTimestamp(LocalDateTime.of(2020, 9, 1, 1, 1))
                .lastUpdateTimestamp(LocalDateTime.of(2020, 11, 1, 1, 1))
                .build();
    }

    private List<RoomDTO> roomExamples() {
        RoomDTO room1 = RoomDTO.builder()
                .roomNumber("101")
                .roomType("Suite")
                .maxOccupancy(4)
                .ratePerDay(BigDecimal.valueOf(1000.00))
                .active(true)
                .description("Big room")
                .build();

        RoomDTO room2 = RoomDTO.builder()
                .roomNumber("102")
                .roomType("Medium")
                .maxOccupancy(3)
                .ratePerDay(BigDecimal.valueOf(750.00))
                .active(true)
                .description("Medium room")
                .build();

        RoomDTO room3 = RoomDTO.builder()
                .roomNumber("103")
                .roomType("Normal")
                .maxOccupancy(2)
                .ratePerDay(BigDecimal.valueOf(500.00))
                .active(true)
                .description("Small room")
                .build();

        return List.of(room1, room2, room3);
    }
}
