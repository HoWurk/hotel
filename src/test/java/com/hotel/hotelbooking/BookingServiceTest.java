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

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {

    @Mock
    private BookingRepository bookingRepository;

    @Mock
    private RoomRepository roomRepository;

    @Mock
    private Mapper mapper;

    @InjectMocks
    private BookingServiceImpl bookingService;

    @Test
    public void testGetAvailableRooms() {
        LocalDateTime startDate = LocalDateTime.of(2023, 9, 9, 0, 0);
        LocalDateTime endDate = LocalDateTime.of(2023, 9, 11, 0, 0);
        DateTimeSpan span = DateTimeSpan.builder()
                .start_date(startDate)
                .end_date(endDate)
                .build();
        List<Room> allRooms = getRoomsExample();
        List<Booking> overlappingBookings = getBookingsExample(allRooms);

        when(bookingRepository.findOverlappingBookings(startDate, endDate))
                .thenReturn(overlappingBookings);
        when(roomRepository.findAll()).thenReturn(allRooms);
        when(mapper.toDto(any(Room.class))).thenAnswer(invocation -> {
            Room room = invocation.getArgument(0);
            return RoomDTO.builder()
                    .roomNumber(room.getRoomNumber())
                    .roomType(room.getRoomType())
                    .maxOccupancy(room.getMaxOccupancy())
                    .active(room.getActive())
                    .description(room.getDescription())
                    .build();
        });

        List<RoomDTO> availableRooms = bookingService.getAvailableRooms(span);

        RoomDTO correctRoom1 = mapper.toDto(allRooms.get(0));
        RoomDTO correctRoom2 = mapper.toDto(allRooms.get(2));
        assertNotNull(availableRooms);
        assertEquals(2, availableRooms.size());
        assertTrue(availableRooms.contains(correctRoom1));
        assertTrue(availableRooms.contains(correctRoom2));

    }

    private List<Room> getRoomsExample() {
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