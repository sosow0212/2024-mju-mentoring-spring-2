package com.racing.web.controller;

import com.racing.common.domain.*;
import com.racing.web.service.RacingService;
import com.racing.web.service.dto.CreateCars;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    private ResponseEntity<Map<String,Object>> getResult() {
        List<String> winner = cars.getWinner();
        List<Map<String, Integer>> carStates = new ArrayList<>();
        for(Car car : cars.getCars()){
            carStates.add(car.getStatus());
        }
        return ResponseEntity.ok(racingService.getResult(carStates, winner));
    }

    @GetMapping("/cars/name")
    private ResponseEntity<Map<String, Integer>> getResultByName(@RequestParam("name") String name) {
        List<Map<String, Integer>> carStates = new ArrayList<>();
        for(Car car : cars.getCars()){
            carStates.add(car.getStatus());
        }
        return ResponseEntity.ok(racingService.getResultByName(carStates, name));
    }
}
