package com.recruitment.task.reservations.dto;

import java.time.LocalDateTime;

public record ScreeningDto(Long id, LocalDateTime time, MoviePreviewDto moviePreviewDto) {
}
