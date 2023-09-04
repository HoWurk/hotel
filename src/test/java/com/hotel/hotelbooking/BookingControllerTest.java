package com.hotel.hotelbooking;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hotel.hotelbooking.model.DateTimeSpan;
import com.hotel.hotelbooking.model.RoomDTO;
import com.hotel.hotelbooking.service.BookingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class BookingControllerTest {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private BookingService bookingService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void givenBookings_whenGetRooms_thenStatus200() throws Exception {
        DateTimeSpan span = DateTimeSpan.builder()
                .start_date(LocalDateTime.parse("2023-09-09T00:00:00"))
                .end_date(LocalDateTime.parse("2023-09-11T00:00:00"))
                .build();
        String spanJson = objectMapper.writeValueAsString(span);
        when(bookingService.getAvailableRooms(span))
                .thenReturn(getRoomsExample());

        mvc.perform(post("/bookings/available")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(spanJson)
                )

                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(jsonPath("$", hasSize(3)));
        verify(bookingService, times(1)).getAvailableRooms(any());
    }

    private List<RoomDTO> getRoomsExample() {
        RoomDTO room1 = RoomDTO.builder()
                .roomNumber("101")
                .roomType("Suite")
                .maxOccupancy(4)
                .ratePerDay(BigDecimal.valueOf(1000.00))
                .active(true)
                .description("Big room")
                .build();
        RoomDTO room2 = RoomDTO.builder()
                .roomNumber("102")
                .roomType("Suite")
                .maxOccupancy(4)
                .ratePerDay(BigDecimal.valueOf(1000.00))
                .active(true)
                .description("Big room")
                .build();
        RoomDTO room3 = RoomDTO.builder()
                .roomNumber("201")
                .roomType("Suite")
                .maxOccupancy(4)
                .ratePerDay(BigDecimal.valueOf(1000.00))
                .active(true)
                .description("Big room")
                .build();
        return List.of(room1, room2, room3);
    }
}
