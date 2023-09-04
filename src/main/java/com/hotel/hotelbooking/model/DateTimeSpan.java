package com.hotel.hotelbooking.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class DateTimeSpan {

    private LocalDateTime start_date;

    private LocalDateTime end_date;
}
