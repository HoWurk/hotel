package com.hotel.hotelbooking;

import com.hotel.hotelbooking.entity.Booking;
import com.hotel.hotelbooking.entity.Room;
import com.hotel.hotelbooking.repository.BookingRepository;
import com.hotel.hotelbooking.repository.RoomRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@TestPropertySource(locations = "classpath:application-test.properties")
public class BookingRepositoryTest {

    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private RoomRepository roomRepository;

    @Test
    public void whenFindOverlappingBookings_thenReturnBookings() {
        Room room = getRoomExample();
        List<Booking> bookings = getBookingsExample(room);
        roomRepository.save(room);
        bookingRepository.saveAll(bookings);
        LocalDateTime start_date = LocalDateTime.of(2023, 9, 9, 15, 0);
        LocalDateTime end_date = LocalDateTime.of(2023, 9, 11, 15, 0);

        List<Booking> overlappingBookings = bookingRepository.findOverlappingBookings(start_date, end_date);

        assertNotNull(overlappingBookings);
        assertTrue(overlappingBookings.contains(bookings.get(0)));
        assertTrue(overlappingBookings.contains(bookings.get(2)));
        assertFalse(overlappingBookings.contains(bookings.get(1)));
    }

    private Room getRoomExample() {
        return Room.builder()
                .id(1)
                .roomNumber("101")
                .roomType("Suite")
                .maxOccupancy(4)
                .ratePerDay(BigDecimal.valueOf(1000.00))
                .active(true)
                .description("Big room")
                .build();
    }

    private List<Booking> getBookingsExample(Room room){
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
}
