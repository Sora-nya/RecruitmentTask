package com.recruitment.task.reservations.repository;

import com.recruitment.task.reservations.entity.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat,Long> {
}
