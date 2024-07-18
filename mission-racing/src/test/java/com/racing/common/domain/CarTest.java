package com.racing.common.domain;

import com.racing.common.domain.FakeRandomNumber.FakeRandomNumber;
import com.racing.common.domain.vo.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CarTest {

    @Test
    @DisplayName("자동차 움직이기 테스트 (getMoveCount 테스트 포함)")
    void moveCar() {
        // given
        String carName = "aaa";
        Car car = new Car(carName);
        CreateRandomNumber createRandomNumber = new FakeRandomNumber();
        car.moveCar(createRandomNumber);
        int expected = 1;

        // when
        int actual = car.getMoveCount();

        // then
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("차 이름 반환 테스트")
    void getCarName() {
        // given
        Name carName = new Name("aaa");
        Car car = new Car(carName.getName());
        String expected = "aaa";

        // when
        String actual = car.getCarName();

        // then
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("차 상태 반환 메서드 테스트")
    void getStatus(){
        // given
        Name carName = new Name("aaa");
        Car car = new Car(carName.getName());
        Map<String, Integer> expected = Map.of("aaa",0);

        // when
        Map<String, Integer> actual = car.getStatus();

        // then
        assertEquals(expected, actual);
    }
}
