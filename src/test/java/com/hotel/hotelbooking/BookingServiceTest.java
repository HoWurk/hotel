package com.hotel.hotelbooking;

import com.hotel.hotelbooking.converter.Mapper;
import com.hotel.hotelbooking.entity.Booking;
import com.hotel.hotelbooking.entity.Room;
import com.hotel.hotelbooking.model.DateTimeSpan;
import com.hotel.hotelbooking.model.RoomDTO;
import com.hotel.hotelbooking.repository.BookingRepository;
import com.hotel.hotelbooking.repository.RoomRepository;
import com.hotel.hotelbooking.service.impl.BookingServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private Mapper mapper;

    @InjectMocks
    private BookingServiceImpl bookingService;

    @Test
    public void testGetAvailableRooms() {
        LocalDateTime startDate = LocalDateTime.of(2023, 9, 9, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2023, 9, 11, 0, 0);
        DateTimeSpan span = DateTimeSpan.builder()
                .startDate(startDate)
                .endDate(endDate)
                .build();
        List<Room> allRooms = TestUtils.getRoomsExample();
        List<RoomDTO> roomDTOS = allRooms.stream().map(mapper::toDto).toList();
        when(bookingRepository.findOverlappingBookings(startDate, endDate))
                .thenReturn(allRooms);

        List<RoomDTO> availableRooms = bookingService.getAvailableRooms(span);

        assertNotNull(availableRooms);
        assertEquals(3, availableRooms.size());
        assertTrue(availableRooms.containsAll(roomDTOS));
    }


    private List<Booking> getBookingsExample(List<Room> rooms) {
        Booking booking1 = Booking.builder()
                .id(1)
                .room(rooms.get(1))
                .checkInDate(LocalDateTime.of(2023, 9, 10, 14, 0))
                .checkOutDate(LocalDateTime.of(2023, 9, 15, 10, 0))
                .guestsAmount(2)
                .guestsInfo("Couple")
                .creationTimestamp(LocalDateTime.of(2023, 8, 25, 11, 45))
                .lastUpdateTimestamp(LocalDateTime.of(2023, 8, 30, 9, 30))
                .build();
        Booking booking3 = Booking.builder()
                .id(3)
                .room(rooms.get(1))
                .checkInDate(LocalDateTime.of(2023, 9, 11, 15, 0))
                .checkOutDate(LocalDateTime.of(2023, 9, 13, 11, 0))
                .guestsAmount(3)
                .guestsInfo("Family")
                .creationTimestamp(LocalDateTime.of(2023, 8, 27, 9, 0))
                .lastUpdateTimestamp(LocalDateTime.of(2023, 8, 29, 17, 45))
                .build();
        return List.of(booking1, booking3);
    }
}