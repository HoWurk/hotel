package com.hotel.hotelbooking.model;

import lombok.*;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Room {
    private Integer id;

    private String roomNumber;

    private String roomType;

    private Integer maxOccupancy;

    private BigDecimal ratePerDay;

    private boolean active;

    private String description;
}
