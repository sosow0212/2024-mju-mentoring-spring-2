package com.example.racingspring.controller;

import com.example.racingspring.domain.Cars;
import com.example.racingspring.domain.dto.StartRaceRequest;
import com.example.racingspring.domain.dto.WinnerResponse;
import com.example.racingspring.service.RacingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cars")
public class RacingSpringController {

    private final RacingService racingService;

    @Autowired
    public RacingSpringController(RacingService racingService) {
        this.racingService = racingService;
    }

    @PostMapping("/racing")
    public WinnerResponse startRace(@RequestBody StartRaceRequest request) {
        Cars cars = racingService.createCars(request.getCarNames());
        return racingService.race(cars, request.getTryCount());
    }
}
