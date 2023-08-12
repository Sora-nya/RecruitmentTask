package com.recruitment.task.reservations.service;

import com.recruitment.task.reservations.dto.MoviePreviewDto;
import com.recruitment.task.reservations.dto.ScreeningDto;
import com.recruitment.task.reservations.entity.Movie;
import com.recruitment.task.reservations.entity.Room;
import com.recruitment.task.reservations.entity.Screening;
import com.recruitment.task.reservations.repository.MovieRepository;
import com.recruitment.task.reservations.repository.RoomRepository;
import com.recruitment.task.reservations.repository.ScreeningRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;
import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@SpringBootTest
class ScreeningServiceTest {

    @Autowired
    ScreeningService screeningService;

    @Autowired
    ScreeningRepository screeningRepository;

    @Autowired
    MovieRepository movieRepository;

    @Autowired
    RoomRepository roomRepository;

    private final LocalDateTime BarbieTime = LocalDateTime.of(2023, 8, 12, 16, 0);
    private final LocalDateTime OppenheimerTime = LocalDateTime.of(2023, 8, 12, 16, 30);

    @BeforeEach
    void setUp() {
        var barbieMovie = movieRepository.save(new Movie("Barbie"));
        var oppenheimerMovie = movieRepository.save(new Movie("Oppenheimer"));
        var room2 = roomRepository.save(new Room("Sala 2"));
        var room1 = roomRepository.save(new Room("Sala 1"));

        screeningRepository.save(new Screening(barbieMovie, room1, BarbieTime));
        screeningRepository.save(new Screening(oppenheimerMovie, room2, OppenheimerTime));
    }

    @AfterEach
    void tearDown() {
        screeningRepository.deleteAll();
    }

    @Test
    void get_all_screenings_in_time_interval() {
        // given
        MoviePreviewDto moviePreviewDtoBarbie = new MoviePreviewDto("Barbie");
        MoviePreviewDto moviePreviewDtoOppenheimer = new MoviePreviewDto("Oppenheimer");
        ScreeningDto screeningDto1 = new ScreeningDto(1L, BarbieTime, moviePreviewDtoBarbie);
        ScreeningDto screeningDto2 = new ScreeningDto(2L, OppenheimerTime, moviePreviewDtoOppenheimer);
        // when

        List<ScreeningDto> screenings = screeningService.getAllScreeningsFromDateAndTime(LocalDateTime.of(2023, 8, 12, 15, 30));

        // then

        assertThat(screenings).containsExactly(screeningDto1, screeningDto2);

    }
}