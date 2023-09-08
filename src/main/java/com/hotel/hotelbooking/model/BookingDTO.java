package com.hotel.hotelbooking.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class BookingDTO {

    private Integer roomId;

    private LocalDateTime checkInDate;

    private LocalDateTime checkOutDate;

    private Integer guestsAmount;

    private String guestsInfo;

    private LocalDateTime creationTimestamp;

    private LocalDateTime lastUpdateTimestamp;
}
