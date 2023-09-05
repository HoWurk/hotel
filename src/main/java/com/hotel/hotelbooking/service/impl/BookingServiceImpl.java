package com.hotel.hotelbooking.service.impl;

import com.hotel.hotelbooking.converter.Mapper;
import com.hotel.hotelbooking.model.BookingDTO;
import com.hotel.hotelbooking.model.DateTimeSpan;
import com.hotel.hotelbooking.model.RoomDTO;
import com.hotel.hotelbooking.repository.BookingRepository;
import com.hotel.hotelbooking.service.BookingService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final Mapper mapper;

    @Override
    public List<RoomDTO> getAvailableRooms(DateTimeSpan span) {
        return bookingRepository.findOverlappingBookings(span.getStartDate(), span.getEndDate()).stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public BookingDTO createBooking(BookingDTO booking) {
        throw new UnsupportedOperationException("This method is not supported");
    }


}
