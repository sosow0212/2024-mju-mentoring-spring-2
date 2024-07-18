package com.racing.web.controller;

import com.racing.common.domain.Car;
import com.racing.common.domain.Cars;

import com.racing.web.controller.dto.CarResponse;

import com.racing.web.service.RacingService;

import com.racing.web.controller.dto.CarState;
import com.racing.web.controller.dto.StartRaceRequest;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/cars")
public class WebController {

    private final RacingService racingService;

    public WebController(RacingService racingService) {
        this.racingService = racingService;
    }

    @PostMapping
    public void registerCars(@RequestBody StartRaceRequest request) {
        racingService.registerCars(request);
    }

    @PostMapping("/racing")
    public CarResponse startRace(@RequestBody StartRaceRequest request) {
        Cars cars = racingService.startRace(request);
        return CarResponse.from(cars);
    }

    @GetMapping
    public CarResponse getRaceResult() {
        Cars cars = racingService.getRaceResult();
        return CarResponse.from(cars);
    }

    @GetMapping(params = "name")
    public CarState findByName(@RequestParam("name") String name) {
        Car car = racingService.getCarStateByName(name);
        return CarState.from(car);
    }
}
