package com.racing.controller;

import com.racing.exception.CarNotFoundException;
import com.racing.model.Car;
import com.racing.model.Cars;
import com.racing.service.dto.CarStatus;
import com.racing.service.dto.RaceResult;
import com.racing.service.dto.CarRegisterRequest;
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
    public ResponseEntity<Void> registerCars(@RequestBody CarRegisterRequest registerRequest) {
        racingService.registerCars(registerRequest);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/racing")
    public ResponseEntity<Void> startRace() {
        racingService.race();
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity<RaceResult> getRaceResults() {
        Cars cars = racingService.getCarResult();
        RaceResult resultResponse = RaceResult.resultResponse(cars);
        return ResponseEntity.ok(resultResponse);
    }

    @GetMapping(params = "name")
    public ResponseEntity<CarStatus> getCarStatus(@RequestParam("name") String name) {
        Car car = racingService.findCarByName(name);
        CarStatus statusResponse = new CarStatus(car.getName(), car.getPosition());
        return ResponseEntity.ok(statusResponse);
    }
}
