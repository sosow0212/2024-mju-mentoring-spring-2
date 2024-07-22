package com.racing.web.controller;

import com.racing.web.dto.CarResultResponse;
import com.racing.web.random.CreateRandomNumber;
import com.racing.web.service.RacingService;
import com.racing.web.dto.CreateRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/api")
public class WebController {

    private final RacingService racingService;
    private final CreateRandomNumber createRandomNumber;

    public WebController(RacingService racingService, CreateRandomNumber createRandomNumber) {
        this.racingService = racingService;
        this.createRandomNumber = createRandomNumber;
    }

    @PostMapping("/create")
    private ResponseEntity<Void> createCars(@RequestBody CreateRequest createRequest) {
        racingService.createCars(createRequest);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PostMapping("/cars/racing")
    private ResponseEntity<Void> starRace() {
        racingService.startRace(createRandomNumber);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/cars")
    private ResponseEntity<CarResultResponse> getResult() {
        return ResponseEntity.ok(racingService.getResult());
    }

    @GetMapping(value = "/cars", params = "name")
    private ResponseEntity<Optional<Map<String, Integer>>> getResultByName(@RequestParam("name") String name) {
        return ResponseEntity.ok(racingService.findResultByName(name));
    }
}
