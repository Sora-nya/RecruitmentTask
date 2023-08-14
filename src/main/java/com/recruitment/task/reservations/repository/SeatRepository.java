package com.recruitment.task.reservations.repository;

import com.recruitment.task.reservations.entity.Room;
import com.recruitment.task.reservations.entity.Screening;
import com.recruitment.task.reservations.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SeatRepository extends JpaRepository<Seat,Long> {

    @Query("SELECT s FROM Seat s " +
            "WHERE s.room = :room AND s NOT IN " +
            "(SELECT rs.seat FROM ReservedSeat rs WHERE rs.reservation.screening = :screening)")
    List<Seat> findAvailableSeatsForScreeningRoom(@Param("room") Room room, @Param("screening") Screening screening);
}
