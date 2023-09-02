package com.hotel.hotelbooking.service;

import com.hotel.hotelbooking.model.Room;

import java.util.List;
import java.util.Optional;

public interface RoomService {

    List<Room> getAllRooms();

    Optional<Room> getRoomById(Integer id);

    Room createRoom(Room room);

    boolean deleteRoom(Integer id);

    Optional<Room> updateRoom(Integer id, Room room);

    Optional<Room> updateRoomStatus(Integer id, boolean status);

}
