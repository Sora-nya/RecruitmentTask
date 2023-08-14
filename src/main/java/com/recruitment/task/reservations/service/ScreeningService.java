package com.recruitment.task.reservations.service;

import com.recruitment.task.reservations.dto.MoviePreviewDto;
import com.recruitment.task.reservations.dto.ScreeningDetailsDto;
import com.recruitment.task.reservations.dto.ScreeningDto;
import com.recruitment.task.reservations.entity.Room;
import com.recruitment.task.reservations.entity.Screening;
import com.recruitment.task.reservations.entity.Seat;
import com.recruitment.task.reservations.repository.ScreeningRepository;
import com.recruitment.task.reservations.repository.SeatRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

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
        Room screeningRoom = screening.getRoom();
        List<Seat> seats = seatRepository.findAvailableSeatsForScreeningRoom(screeningRoom,screening);
        return new ScreeningDetailsDto(screeningRoom,seats);
    }


}
