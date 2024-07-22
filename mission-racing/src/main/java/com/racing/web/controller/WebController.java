package com.racing.web.controller;

import com.racing.web.dto.CarResultResponse;
import com.racing.web.dto.CarStatusResponse;
import com.racing.web.service.RacingService;
import com.racing.web.dto.CreateRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/api")
public class WebController {

    private final RacingService racingService;

    public WebController(RacingService racingService) {
        this.racingService = racingService;
    }

    @PostMapping("/create")
    private ResponseEntity<Void> createCars(@RequestBody CreateRequest createRequest) {
        racingService.createCars(createRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @PostMapping("/cars/racing")
    private ResponseEntity<Void> starRace() {
        racingService.startRace();
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/cars")
    private ResponseEntity<CarResultResponse> getResult() {
        return ResponseEntity.ok(racingService.getResult());
    }

    @GetMapping(value = "/cars", params = "name")
    private ResponseEntity<CarStatusResponse> getResultByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(racingService.getResultByName(name));
    }
}
