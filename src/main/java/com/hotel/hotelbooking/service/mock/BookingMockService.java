package com.hotel.hotelbooking.service.mock;

import com.hotel.hotelbooking.model.Booking;
import com.hotel.hotelbooking.model.Room;
import com.hotel.hotelbooking.service.BookingService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class BookingMockService implements BookingService {
    @Override
    public List<Room> getAvailableRooms() {
        return roomExamples();
    }

    @Override
    public Booking createBooking(Booking booking) {
        return Booking.builder()
                .id(1)
                .roomId(1)
                .checkInDate(LocalDateTime.of(2020, 10, 9, 8, 7))
                .checkOutDate(LocalDateTime.of(2020, 11, 9, 8, 7))
                .guestsAmount(3)
                .guestsInfo("Family")
                .creationTimestamp(LocalDateTime.of(2020, 9, 1, 1, 1))
                .lastUpdateTimestamp(LocalDateTime.of(2020, 11, 1, 1, 1))
                .build();
    }

    private List<Room> roomExamples() {
        Room room1 = Room.builder()
                .id(1)
                .roomNumber("101")
                .roomType("Suite")
                .maxOccupancy(4)
                .ratePerDay(BigDecimal.valueOf(1000.00))
                .active(true)
                .description("Big room")
                .build();

        Room room2 = Room.builder()
                .id(2)
                .roomNumber("102")
                .roomType("Medium")
                .maxOccupancy(3)
                .ratePerDay(BigDecimal.valueOf(750.00))
                .active(true)
                .description("Medium room")
                .build();

        Room room3 = Room.builder()
                .id(3)
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
