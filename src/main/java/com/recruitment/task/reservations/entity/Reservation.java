package com.recruitment.task.reservations.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
public class Reservation {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;

        @ManyToOne
        @JoinColumn(name = "screening_id")
        private Screening screening;

        @ManyToOne
        @JoinColumn(name = "user_id")
        private User user;

        private LocalDateTime reservationTime;
        private LocalDateTime expirationTime;
        private BigDecimal totalAmount;

    public Reservation() {
    }

    public Reservation(Screening screening, User user, LocalDateTime reservationTime, LocalDateTime expirationTime, BigDecimal totalAmount) {
        this.screening = screening;
        this.user = user;
        this.reservationTime = reservationTime;
        this.expirationTime = expirationTime;
        this.totalAmount = totalAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Screening getScreening() {
        return screening;
    }

    public void setScreening(Screening screening) {
        this.screening = screening;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public LocalDateTime getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDateTime reservationTime) {
        this.reservationTime = reservationTime;
    }

    public LocalDateTime getExpirationTime() {
        return expirationTime;
    }

    public void setExpirationTime(LocalDateTime expirationTime) {
        this.expirationTime = expirationTime;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
