package com.hotel.hotelbooking;

import com.hotel.hotelbooking.converter.Mapper;
import com.hotel.hotelbooking.entity.Booking;
import com.hotel.hotelbooking.entity.Room;
import com.hotel.hotelbooking.model.DateTimeSpan;
import com.hotel.hotelbooking.model.RoomDTO;
import com.hotel.hotelbooking.repository.BookingRepository;
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
}