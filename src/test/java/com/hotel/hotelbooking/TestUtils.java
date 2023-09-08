package com.hotel.hotelbooking;

import com.hotel.hotelbooking.entity.Booking;
import com.hotel.hotelbooking.entity.Room;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public class TestUtils {

    public static Room getRoomExample() {
        return getRoomsExample().get(0);
    }

    public static List<Room> getRoomsExample() {
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
                .roomType("Suite")
                .maxOccupancy(4)
                .ratePerDay(BigDecimal.valueOf(1000.00))
                .active(true)
                .description("Big room")
                .build();

        Room room3 = Room.builder()
                .id(3)
                .roomNumber("201")
                .roomType("Suite")
                .maxOccupancy(4)
                .ratePerDay(BigDecimal.valueOf(1000.00))
                .active(true)
                .description("Big room")
                .build();

        return List.of(room1, room2, room3);
    }

    public static List<Booking> getSingleRoomBookingsExample() {
        return getSingleRoomBookingsExample(getRoomExample());
    }

    public static List<Booking> getSingleRoomBookingsExample(Room room) {
        Booking booking1 = Booking.builder()
                .id(1)
                .room(room)
                .checkInDate(LocalDateTime.of(2023, 9, 10, 14, 0))
                .checkOutDate(LocalDateTime.of(2023, 9, 15, 10, 0))
                .guestsAmount(2)
                .guestsInfo("Couple")
                .creationTimestamp(LocalDateTime.of(2023, 8, 25, 11, 45))
                .lastUpdateTimestamp(LocalDateTime.of(2023, 8, 30, 9, 30))
                .build();

        Booking booking2 = Booking.builder()
                .id(2)
                .room(room)
                .checkInDate(LocalDateTime.of(2023, 9, 12, 12, 0))
                .checkOutDate(LocalDateTime.of(2023, 9, 14, 12, 0))
                .guestsAmount(1)
                .guestsInfo("Solo traveler")
                .creationTimestamp(LocalDateTime.of(2023, 8, 28, 15, 30))
                .lastUpdateTimestamp(LocalDateTime.of(2023, 8, 31, 10, 15))
                .build();

        Booking booking3 = Booking.builder()
                .id(3)
                .room(room)
                .checkInDate(LocalDateTime.of(2023, 9, 11, 15, 0))
                .checkOutDate(LocalDateTime.of(2023, 9, 13, 11, 0))
                .guestsAmount(3)
                .guestsInfo("Family")
                .creationTimestamp(LocalDateTime.of(2023, 8, 27, 9, 0))
                .lastUpdateTimestamp(LocalDateTime.of(2023, 8, 29, 17, 45))
                .build();

        return List.of(booking1, booking2, booking3);
    }

    public static List<Booking> getMultipleRoomBookingsExample(List<Room> rooms) {
        Booking booking1 = Booking.builder()
                .id(1)
                .room(rooms.get(0))
                .checkInDate(LocalDateTime.of(2023, 9, 10, 14, 0))
                .checkOutDate(LocalDateTime.of(2023, 9, 15, 10, 0))
                .guestsAmount(2)
                .guestsInfo("Couple")
                .creationTimestamp(LocalDateTime.of(2023, 8, 25, 11, 45))
                .lastUpdateTimestamp(LocalDateTime.of(2023, 8, 30, 9, 30))
                .build();

        Booking booking2 = Booking.builder()
                .id(2)
                .room(rooms.get(1))
                .checkInDate(LocalDateTime.of(2023, 9, 12, 12, 0))
                .checkOutDate(LocalDateTime.of(2023, 9, 14, 12, 0))
                .guestsAmount(1)
                .guestsInfo("Solo traveler")
                .creationTimestamp(LocalDateTime.of(2023, 8, 28, 15, 30))
                .lastUpdateTimestamp(LocalDateTime.of(2023, 8, 31, 10, 15))
                .build();

        Booking booking3 = Booking.builder()
                .id(3)
                .room(rooms.get(2))
                .checkInDate(LocalDateTime.of(2023, 9, 11, 15, 0))
                .checkOutDate(LocalDateTime.of(2023, 9, 13, 11, 0))
                .guestsAmount(3)
                .guestsInfo("Family")
                .creationTimestamp(LocalDateTime.of(2023, 8, 27, 9, 0))
                .lastUpdateTimestamp(LocalDateTime.of(2023, 8, 29, 17, 45))
                .build();

        return List.of(booking1, booking2, booking3);
    }

}
