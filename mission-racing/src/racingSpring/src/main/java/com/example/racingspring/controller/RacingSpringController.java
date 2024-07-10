package com.example.racingspring.controller;

import com.example.racingspring.domain.Cars;
import com.example.racingspring.domain.dto.WinnerResponse;
import com.example.racingspring.service.RacingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/racing")
public class RacingSpringController {

    private final RacingService racingService;

    @Autowired
    public RacingSpringController(RacingService racingService) {
        this.racingService = racingService;
    }

    @PostMapping("/start")
    public WinnerResponse startRace(@RequestParam String carNames, @RequestParam int tryCount) {
        Cars cars = racingService.createCars(carNames);
        return racingService.race(cars, tryCount);
    }
}
