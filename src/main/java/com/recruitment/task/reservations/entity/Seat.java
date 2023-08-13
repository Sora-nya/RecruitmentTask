package com.recruitment.task.reservations.entity;

import jakarta.persistence.*;

@Entity
public class Seat {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "room_id")
        private Room room;

        private int rowNumber;
        private int seatNumber;

    public Seat() {
    }

    public Seat(Room room, int rowNumber, int seatNumber) {
        this.room = room;
        this.rowNumber = rowNumber;
        this.seatNumber = seatNumber;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public int getRowNumber() {
        return rowNumber;
    }

    public void setRowNumber(int rowNumber) {
        this.rowNumber = rowNumber;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }
}
