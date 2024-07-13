package com.racing.web.controller;

import com.racing.common.controller.dto.WinnerResponse;
import com.racing.web.service.RacingService;
import com.racing.web.service.dto.StartRaceRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/cars")
public class WebController {

    private final RacingService racingService;

    public WebController(RacingService racingService) {
        this.racingService = racingService;
    }

    @PostMapping("/racing")
    public WinnerResponse startRace(@RequestBody StartRaceRequest request) {
        return racingService.startRace(request);
    }
}
