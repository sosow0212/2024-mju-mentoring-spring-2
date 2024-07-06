package com.racing;

import com.racing.model.Car;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CarTest {

    @Test
    void 랜덤숫자_범위_테스트() {
        Car car = new Car("car1");
        int randomNumber = car.getRandomNumber();
        Assertions.assertTrue(randomNumber >= 0 && randomNumber <= 9);
    }

    @Test
    void car_이동했을때_위치_확인_테스트() {
        Car car = new Car("car1");
        car.carMovePosition();
        int expected = 1;

        int actual = car.getPosition();
        Assertions.assertEquals(expected, actual);
    }
}
