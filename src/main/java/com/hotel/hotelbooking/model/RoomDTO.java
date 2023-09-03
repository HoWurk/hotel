package com.hotel.hotelbooking.model;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
@Builder
public class RoomDTO {

    private String roomNumber;

    private String roomType;

    private Integer maxOccupancy;

    private BigDecimal ratePerDay;

    private boolean active;

    private String description;
}
