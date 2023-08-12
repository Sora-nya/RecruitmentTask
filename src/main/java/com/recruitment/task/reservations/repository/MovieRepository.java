package com.recruitment.task.reservations.repository;

import com.recruitment.task.reservations.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
}
