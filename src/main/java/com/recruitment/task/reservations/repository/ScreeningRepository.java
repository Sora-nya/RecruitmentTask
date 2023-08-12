package com.recruitment.task.reservations.repository;

import com.recruitment.task.reservations.entity.Screening;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreeningRepository extends JpaRepository<Screening,Long> {
}
