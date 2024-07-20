package com.racing;

import com.racing.model.Car;
import com.racing.service.RacingService;
import com.racing.service.dto.CarRegister;
import com.racing.service.dto.CarStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;


@SpringBootTest
public class RacingServiceTest {
    @Test
    void 자동차_등록_테스트() {
        CarRegister carRegister = new CarRegister("car1,car2,car3", 5);
        RacingService racingService = new RacingService();

        racingService.registerCars(carRegister);

        List<Car> cars = racingService.getCars();
        Assertions.assertEquals(3, cars.size());
    }

    @Test
    void 개별_자동차_조회_테스트() {
        CarRegister carRegister = new CarRegister("car1,car2,car3", 5);
        RacingService racingService = new RacingService();

        racingService.registerCars(carRegister);
        racingService.race();

        CarStatus carStatus = racingService.getCarStatus("car1");
        Assertions.assertEquals("car1", carStatus.name());
    }
}
