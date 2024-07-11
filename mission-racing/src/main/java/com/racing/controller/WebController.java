package com.racing.controller;

import com.racing.service.dto.StartRaceRequest;
import com.racing.view.dto.WinnerResponse;
import com.racing.service.RacingService;
import org.springframework.web.bind.annotation.*;

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
