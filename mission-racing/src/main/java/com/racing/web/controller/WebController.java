package com.racing.web.controller;

import com.racing.web.service.RacingService;
import com.racing.web.service.dto.CreateCars;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class WebController {

    private final RacingService racingService;

    public WebController(RacingService racingService) {
        this.racingService = racingService;
    }

    @PostMapping("/create")
    private CreateCars createCars(@RequestBody CreateCars createCars) {
        racingService.createCars(createCars);
        return createCars;
    }
}
