package com.racing;

import com.racing.model.Car;
import com.racing.model.Cars;
import com.racing.model.RandomNumber;
import com.racing.repository.CarRepository;
import com.racing.service.RacingService;
import com.racing.service.dto.CarRegisterRequest;
import com.racing.service.dto.CarStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class RacingServiceTest {

    private CarRepository carRepository;
    private RandomNumber randomNumber;
    private RacingService racingService;

    @Test
    void 자동차_등록_테스트() {
        carRepository = new CarRepository();
        racingService = new RacingService(carRepository, randomNumber);
        CarRegisterRequest carRegister = new CarRegisterRequest("car1,car2,car3", 5);
        racingService.registerCars(carRegister);

        Cars cars = racingService.getCarResult();
        Assertions.assertEquals(3, cars.getCarList().size());
    }

    @Test
    void 개별_자동차_조회_테스트() {
        carRepository = new CarRepository();
        racingService = new RacingService(carRepository, randomNumber);
        CarRegisterRequest carRegister = new CarRegisterRequest("car1,car2,car3", 5);
        racingService.registerCars(carRegister);

        Car car = racingService.findCarByName("car1");
        CarStatus carStatus = new CarStatus(car.getName(), car.getPosition());
        Assertions.assertEquals("car1", carStatus.name());
    }
}
