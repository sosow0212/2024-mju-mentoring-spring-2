package com.racing.web.controller;

import com.racing.common.domain.CarNameParser;
import com.racing.common.domain.CarRandomNumber;
import com.racing.common.domain.Cars;
import com.racing.common.domain.CreateRandomNumber;
import com.racing.web.service.RacingService;
import com.racing.web.service.dto.CreateCars;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class WebController {

    private final RacingService racingService;
    private Cars cars;
    private int tryCount;

    public WebController(RacingService racingService) {
        this.racingService = racingService;
    }

    @PostMapping("/create")
    private void createCars(@RequestBody CreateCars createCars) {
        CarNameParser carNameParser = new CarNameParser(createCars.name());
        this.cars = racingService.createCars(carNameParser.getCarNames());
        this.tryCount = createCars.tryCount();
    }

    @PostMapping("/cars/racing")
    private void starRace() {
        CreateRandomNumber createRandomNumber = new CarRandomNumber();
        racingService.startRace(cars, createRandomNumber, tryCount);
    }

    @GetMapping("/cars")
    private ResponseEntity<Map<String, Object>> getResult() {
        List<String> winner = cars.getWinner();
        List<Object> status = cars.getStatus();
        return ResponseEntity.ok(racingService.getResult(status, winner));
    }

    @GetMapping("/cars/name")
    private ResponseEntity<Object> getResultByName(@RequestParam(name = "name") String name) {
        List<Object> status = cars.getStatus();
        return ResponseEntity.ok(racingService.getResultByName(status, name));
    }
}
