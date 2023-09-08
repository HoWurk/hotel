package com.hotel.hotelbooking.service;


import com.hotel.hotelbooking.model.AvailableRoomRequest;
import com.hotel.hotelbooking.model.BookingDTO;
import com.hotel.hotelbooking.model.RoomDTO;

import java.util.List;

public interface BookingService {

    List<RoomDTO> getAvailableRooms(AvailableRoomRequest request);

    BookingDTO createBooking(BookingDTO booking);

}
