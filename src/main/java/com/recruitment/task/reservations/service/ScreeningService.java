package com.recruitment.task.reservations.service;

import com.recruitment.task.reservations.dto.*;
import com.recruitment.task.reservations.entity.Screening;
import com.recruitment.task.reservations.repository.ScreeningRepository;
import com.recruitment.task.reservations.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ScreeningService {
    private final ScreeningRepository screeningRepository;
    private final SeatRepository seatRepository;

    public ScreeningService(ScreeningRepository screeningRepository, SeatRepository seatRepository) {
        this.screeningRepository = screeningRepository;
        this.seatRepository = seatRepository;
    }

    public List<ScreeningDto> getAllScreeningsFromDateAndTime(LocalDateTime chosenTime) {
        List<Screening> screenings = screeningRepository.findScreeningsAfterTime(chosenTime);
        return screenings.stream().map((ScreeningService::createScreeningDto)).toList();
    }

    private static ScreeningDto createScreeningDto(Screening screening) {
        return new ScreeningDto(screening.getId(), screening.getStartTime(), new MoviePreviewDto(screening.getMovie().getTitle()));
    }

    public ScreeningDetailsDto getScreeningRoomAndAvailableSeats(long screeningId) {
        Screening screening = screeningRepository.findById(screeningId).orElseThrow();
        RoomDto screeningRoom = new RoomDto(screening.getRoom().getId(), screening.getRoom().getScreenName());
        List<SeatDto> seats = seatRepository.findAvailableSeatsForScreeningRoom(screening.getRoom(), screening).stream()
                .map(seat -> new SeatDto(seat.getId(), seat.getRowNumber(), seat.getSeatNumber()))
                .collect(Collectors.toList());
        return new ScreeningDetailsDto(screeningRoom, seats);
    }


}
