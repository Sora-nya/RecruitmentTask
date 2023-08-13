package com.recruitment.task.reservations.service;

import com.recruitment.task.reservations.dto.MoviePreviewDto;
import com.recruitment.task.reservations.dto.ScreeningDto;
import com.recruitment.task.reservations.entity.Screening;
import com.recruitment.task.reservations.repository.ScreeningRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScreeningService {
    private final ScreeningRepository screeningRepository;

    public ScreeningService(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    public List<ScreeningDto> getAllScreeningsFromDateAndTime(LocalDateTime chosenTime) {
        List<Screening> screenings = screeningRepository.findScreeningsAfterTime(chosenTime);
        return screenings.stream().map((ScreeningService::createScreeningDto)).toList();
    }

    private static ScreeningDto createScreeningDto(Screening screening) {
        return new ScreeningDto(screening.getId(), screening.getStartTime(), new MoviePreviewDto(screening.getMovie().getTitle()));
    }
}
