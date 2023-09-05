package com.hotel.hotelbooking;

import com.hotel.hotelbooking.entity.Booking;
import com.hotel.hotelbooking.entity.Room;
import com.hotel.hotelbooking.repository.BookingRepository;
import com.hotel.hotelbooking.repository.RoomRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.TestPropertySource;

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

    public static List<Room> rooms = TestUtils.getRoomsExample();
    public static List<Booking> bookings;

    @BeforeEach
    public void setUp() {
        rooms = roomRepository.saveAll(rooms);
        bookings = TestUtils.getMultipleRoomBookingsExample(rooms);
        bookingRepository.saveAll(bookings);
    }

    @Test
    public void whenFindOverlappingBookings_thenReturnRooms() {
        LocalDateTime startDate = LocalDateTime.of(2023, 9, 9, 15, 0);
        LocalDateTime endDate = LocalDateTime.of(2023, 9, 11, 15, 0);

        List<Room> overlappingBookings = bookingRepository.findOverlappingBookings(startDate, endDate);

        assertNotNull(overlappingBookings);
        assertEquals(overlappingBookings.size(), 1);
        assertTrue(overlappingBookings.contains(rooms.get(1)));
    }

    @Test
    public void whenFindOverlappingBookings_andWrongSpan_thenShouldWorkCorrectly() {
        LocalDateTime startDate = LocalDateTime.of(2023, 9, 11, 15, 0);
        LocalDateTime endDate = LocalDateTime.of(2023, 9, 9, 15, 0);

        List<Room> overlappingBookings = bookingRepository.findOverlappingBookings(startDate, endDate);

        assertNotNull(overlappingBookings);
        assertEquals(overlappingBookings.size(), 1);
        assertTrue(overlappingBookings.contains(rooms.get(1)));
    }

    @Test
    public void whenFindOverlappingBookings_andBigSpan_thenShouldReturnEmpty() {
        LocalDateTime startDate = LocalDateTime.of(2023, 9, 9, 15, 0);
        LocalDateTime endDate = LocalDateTime.of(2023, 9, 16, 15, 0);

        List<Room> overlappingBookings = bookingRepository.findOverlappingBookings(startDate, endDate);

        assertNotNull(overlappingBookings);
        assertEquals(overlappingBookings.size(), 0);
    }

    @Test
    public void whenFindOverlappingBookings_andSameDate_thenShouldWorkCorrectly() {
        LocalDateTime startDate = LocalDateTime.of(2023, 9, 16, 15, 0);
        LocalDateTime endDate = LocalDateTime.of(2023, 9, 16, 15, 0);

        List<Room> overlappingBookings = bookingRepository.findOverlappingBookings(startDate, endDate);

        assertNotNull(overlappingBookings);
        assertTrue(overlappingBookings.size() > 0);
    }
}
