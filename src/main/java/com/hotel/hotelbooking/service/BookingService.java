package com.hotel.hotelbooking.service;


import com.hotel.hotelbooking.model.BookingDTO;
import com.hotel.hotelbooking.model.RoomDTO;

import java.time.LocalDateTime;
import java.util.List;

public interface BookingService {

    List<RoomDTO> getAvailableRooms(LocalDateTime start_date, LocalDateTime end_date);

    BookingDTO createBooking(BookingDTO booking);

}
