package com.hotel.hotelbooking.service.impl;

import com.hotel.hotelbooking.converter.Mapper;
import com.hotel.hotelbooking.entity.Booking;
import com.hotel.hotelbooking.model.BookingDTO;
import com.hotel.hotelbooking.model.DateTimeSpan;
import com.hotel.hotelbooking.model.RoomDTO;
import com.hotel.hotelbooking.repository.BookingRepository;
import com.hotel.hotelbooking.repository.RoomRepository;
import com.hotel.hotelbooking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final RoomRepository roomRepository;
    private final Mapper mapper;

    @Override
    public List<RoomDTO> getAvailableRooms(DateTimeSpan span) {
        LocalDateTime start_date = span.getStart_date();
        LocalDateTime end_date = span.getEnd_date();
        List<Booking> overlappingBookings = bookingRepository.findOverlappingBookings(start_date, end_date);

        List<Integer> occupiedRoomIds = overlappingBookings.stream()
                .map(booking -> booking.getRoom().getId())
                .toList();

        return roomRepository.findAll().stream()
                .filter(room -> !occupiedRoomIds.contains(room.getId()))
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookingDTO createBooking(BookingDTO booking) {
        throw new ResponseStatusException(HttpStatus.FORBIDDEN, "This endpoint is blocked");
    }


}
