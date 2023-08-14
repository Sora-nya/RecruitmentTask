package com.recruitment.task.reservations.dto;

import java.util.List;

public record ScreeningDetailsDto(RoomDto screeningRoom, List<SeatDto> avaibleSeats) {
}
