package com.hotel.hotelbooking.service.mock;

import com.hotel.hotelbooking.model.Room;
import com.hotel.hotelbooking.service.RoomService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RoomMockService implements RoomService {

    private final List<Room> rooms = new ArrayList<>();

    RoomMockService() {
        rooms.add(new Room(1, "101", "Standard", 2, BigDecimal.valueOf(100.00), true, "Cozy room 1"));
        rooms.add(new Room(2, "102", "Suite", 3, BigDecimal.valueOf(200.00), true, "Luxurious room 1"));
        rooms.add(new Room(3, "103", "Standard", 2, BigDecimal.valueOf(100.00), true, "Cozy room 2"));
        rooms.add(new Room(4, "202", "Standard", 2, BigDecimal.valueOf(100.00), false, "Cozy room 3"));
        rooms.add(new Room(5, "203", "Suite", 3, BigDecimal.valueOf(200.00), true, "Luxurious room 2"));
    }

    @Override
    public List<Room> getAllRooms() {
        return rooms;
    }

    @Override
    public Optional<Room> getRoomById(Integer id) {
        return rooms.stream().filter(room -> room.getId().equals(id)).findFirst();
    }

    @Override
    public Room createRoom(Room room) {
        room.setId(rooms.size() + 1);
        rooms.add(room);
        return room;
    }

    @Override
    public Optional<Room> updateRoom(Integer id, Room newRoom) {
        Optional<Room> oldRoom = getRoomById(id);
        if (oldRoom.isPresent()) {
            Room roomToUpdate = oldRoom.get();
            roomToUpdate.setRoomNumber(newRoom.getRoomNumber());
            roomToUpdate.setRoomType(newRoom.getRoomType());
            roomToUpdate.setMaxOccupancy(newRoom.getMaxOccupancy());
            roomToUpdate.setRatePerDay(newRoom.getRatePerDay());
            roomToUpdate.setActive(newRoom.isActive());
            roomToUpdate.setDescription(newRoom.getDescription());
            return Optional.of(roomToUpdate);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Room> updateRoomStatus(Integer id, boolean status) {
        Optional<Room> oldRoom = getRoomById(id);
        if (oldRoom.isPresent()) {
            Room roomToUpdate = oldRoom.get();
            roomToUpdate.setActive(status);
            return Optional.of(roomToUpdate);
        }
        return Optional.empty();
    }


    @Override
    public boolean deleteRoom(Integer id) {
        Optional<Room> roomToRemove = rooms.stream().filter(room -> room.getId().equals(id)).findFirst();
        if (roomToRemove.isPresent()) {
            rooms.remove(roomToRemove.get());
            return true;
        }
        return false;
    }
}
