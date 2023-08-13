package com.recruitment.task.reservations.dto;

import com.recruitment.task.reservations.entity.Room;
import com.recruitment.task.reservations.entity.Seat;

import java.util.List;

public record ScreeningDetailsDto(Room screeningRoom, List<Seat> avaibleSeats) {
}
