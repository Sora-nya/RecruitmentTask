package com.recruitment.task.reservations.repository;

import com.recruitment.task.reservations.entity.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
