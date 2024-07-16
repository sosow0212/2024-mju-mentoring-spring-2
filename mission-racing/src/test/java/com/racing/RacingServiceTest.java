package com.racing;

import com.racing.model.Car;
import com.racing.model.Cars;
import com.racing.service.RacingService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.hibernate.validator.internal.util.Contracts.assertTrue;

@SpringBootTest
public class RacingServiceTest {
    @Test
    void 자동차_등록_테스트() {
        RacingService racingService = new RacingService();
        racingService.registerCars("car1,car2,car3", 5);

        List<Car> cars = racingService.getCars();
        Assertions.assertEquals(3, cars.size());
    }

    @Test
    void 개별_자동차_조회_테스트() {
        RacingService racingService = new RacingService();
        racingService.registerCars("car1,car2,car3", 5);
        racingService.race();

        Map<String, Integer> carStatus = racingService.getCarStatus("car1");
        Assertions.assertTrue(carStatus.containsKey("car1"));
    }
}
