package com.racing.controller;

import com.racing.service.dto.CarStatus;
import com.racing.service.dto.RaceResult;
import com.racing.service.dto.CarRegister;
import com.racing.service.RacingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/api/cars")
@RestController
public class RacingController {

    private final RacingService racingService;

    public RacingController(RacingService racingService) {
        this.racingService = racingService;
    }

    @PostMapping
    public void registerCars(@RequestBody CarRegister register) {
        racingService.registerCars(register);
    }

    @PostMapping("/racing")
    public void startRace() {
        racingService.race();
    }

    @GetMapping
    public ResponseEntity<RaceResult> getRaceResults() {
        RaceResult resultResponse = racingService.getRaceResults();
        return ResponseEntity.ok(resultResponse);
    }

    @GetMapping(params = "name")
    public ResponseEntity<CarStatus> getCarStatus(@RequestParam("name") String name) {
        CarStatus statusResponse = racingService.getCarStatus(name);
        return ResponseEntity.ok(statusResponse);
    }
}
