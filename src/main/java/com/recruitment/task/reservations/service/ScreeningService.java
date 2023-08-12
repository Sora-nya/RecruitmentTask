package com.recruitment.task.reservations.service;

import com.recruitment.task.reservations.dto.ScreeningDto;
import com.recruitment.task.reservations.repository.ScreeningRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ScreeningService {
    private final ScreeningRepository screeningRepository;

    public ScreeningService(ScreeningRepository screeningRepository) {
        this.screeningRepository = screeningRepository;
    }

    public List<ScreeningDto> getAllScreeningsFromDateAndTime(LocalDateTime chosenTime) {
        //todo: użyć repo żeby wyciągnąć wszystkie filmy, wifiltorować te po dacie która została podana do końca dnia
        return null;
    }
}
