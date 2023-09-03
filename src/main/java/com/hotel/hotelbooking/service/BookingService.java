package com.hotel.hotelbooking.service;

import com.hotel.hotelbooking.model.Booking;
import com.hotel.hotelbooking.model.Room;

import java.util.List;

public interface BookingService {

    List<Room> getAvailableRooms();

    Booking createBooking(Booking booking);

}
