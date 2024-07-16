package com.racing.controller;

import com.racing.service.RacingService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RequestMapping("/api/cars")
@RestController
public class RacingController {

    private final RacingService racingService;

    public RacingController(RacingService racingService) {
        this.racingService = racingService;
    }

    @PostMapping
    public void registerCars(@RequestBody Map<String, Object> request) {
        String names = (String) request.get("name");
        int tryCount = (int) request.get("tryCount");
        racingService.registerCars(names, tryCount);
    }

    @PostMapping("/racing")
    public void startRace() {
        racingService.race();
    }

    @GetMapping
    public Map<String, Object> getRaceResults() {
        return racingService.getRaceResults();
    }

    @GetMapping(params = "name")
    public Map<String, Integer> getCarStatus(@RequestParam("name") String name) {
        return racingService.getCarStatus(name);
    }
}