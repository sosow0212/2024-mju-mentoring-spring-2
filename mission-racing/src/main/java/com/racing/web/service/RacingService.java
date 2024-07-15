package com.racing.web.service;

import com.racing.common.domain.CarNameParser;
import com.racing.web.service.dto.CreateCars;
import org.springframework.stereotype.Service;

@Service
public class RacingService {

    public void createCars(CreateCars createCars) {
        new CarNameParser(createCars.carNames());
    }
}
