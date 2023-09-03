package com.hotel.hotelbooking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Room {
    private Integer id;

    private String roomNumber;

    private String roomType;

    private Integer maxOccupancy;

    private BigDecimal ratePerDay;

    private boolean active;

    private String description;
}
