package com.racing.controller;

import com.racing.controller.dto.WinnerResponse;
import com.racing.service.RacingService;
import com.racing.service.dto.StartRaceRequest;
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
