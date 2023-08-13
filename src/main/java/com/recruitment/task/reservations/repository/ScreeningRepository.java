package com.recruitment.task.reservations.repository;

import com.recruitment.task.reservations.entity.Screening;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface ScreeningRepository extends JpaRepository<Screening,Long> {

    @Query("SELECT s FROM Screening s WHERE s.startTime > :chosenTime ORDER BY s.movie.title, s.startTime")
    List<Screening> findScreeningsAfterTime(LocalDateTime chosenTime);
}
