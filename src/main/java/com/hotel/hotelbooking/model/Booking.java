package com.hotel.hotelbooking.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Booking {
    private Integer id;

    private Integer roomId;

    private LocalDateTime checkInDate;

    private LocalDateTime checkOutDate;

    private Integer guestsAmount;

    private String guestsInfo;

    private LocalDateTime creationTimestamp;

    private LocalDateTime lastUpdateTimestamp;
}
