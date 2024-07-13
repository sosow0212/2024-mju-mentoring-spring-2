package com.racing.web.controller;

import com.racing.common.dto.ResultResponse;

import com.racing.web.service.RacingService;
import com.racing.web.service.dto.StartRaceRequest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cars")
public class WebController {

    private final RacingService racingService;

    public WebController(RacingService racingService) {
        this.racingService = racingService;
    }

    @PostMapping
    public void registerCars(@RequestBody StartRaceRequest request) {
        racingService.registerCars(request);
    }

    @PostMapping("/racing")
    public ResultResponse startRace(@RequestBody StartRaceRequest request) {
        return racingService.startRace(request);
    }

    @GetMapping
    public ResultResponse getRaceResult() {
        return racingService.getRaceResult();
    }
}
