package com.hotel.hotelbooking.model;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class DateTimeSpan {

    private LocalDateTime startDate;

    private LocalDateTime endDate;
}
