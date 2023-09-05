package com.hotel.hotelbooking.converter;

import com.hotel.hotelbooking.entity.Room;
import com.hotel.hotelbooking.model.RoomDTO;
import org.springframework.stereotype.Component;

@Component
public class Mapper {

    public RoomDTO toDto(Room room) {
        return RoomDTO.builder()
                .roomNumber(room.getRoomNumber())
                .roomType(room.getRoomType())
                .maxOccupancy(room.getMaxOccupancy())
                .active(room.getActive())
                .ratePerDay(room.getRatePerDay())
                .description(room.getDescription())
                .build();
    }

    public Room toRoom(RoomDTO roomDTO) {
        return Room.builder()
                .roomNumber(roomDTO.getRoomNumber())
                .roomType(roomDTO.getRoomType())
                .maxOccupancy(roomDTO.getMaxOccupancy())
                .active(roomDTO.isActive())
                .ratePerDay(roomDTO.getRatePerDay())
                .description(roomDTO.getDescription())
                .build();
    }
}
