package com.hotel.hotelbooking.service;


import com.hotel.hotelbooking.model.BookingDTO;
import com.hotel.hotelbooking.model.DateTimeSpan;
import com.hotel.hotelbooking.model.RoomDTO;

import java.util.List;

public interface BookingService {

    List<RoomDTO> getAvailableRooms(DateTimeSpan dateTimeSpan);

    BookingDTO createBooking(BookingDTO booking);

}
