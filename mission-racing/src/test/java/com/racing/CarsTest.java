package com.racing;

import com.racing.Exception.NameLengthException;
import com.racing.model.Car;
import com.racing.model.Cars;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class CarsTest {

    @Test
    void 이름이_6자_이상일_경우_오류_발생() {
        List<Car> carList = new ArrayList<>();
        Cars cars = new Cars(carList);
        String inputName = "minji,haerin";

        assertThatThrownBy(() -> cars.generateCarList(inputName))
                .isInstanceOf(NameLengthException.class)
                .hasMessageContaining("이름은 5자 이내로 입력 가능합니다.");
    }

    @Test
    void 생성된_Car_개수_테스트() {
        List<Car> carList = new ArrayList<>();
        Cars cars = new Cars(carList);
        String inputName = "minji,hanni,hyein";

        cars.generateCarList(inputName);

        int expected = 3;
        int actual = carList.size();

        assertEquals(expected, actual);
    }

    @Test
    void Cars_이동_테스트() {
        List<Car> carList = new ArrayList<>();
        Cars cars = new Cars(carList);
        Car car1 = new Car("car1");
        Car car2 = new Car("car2");
        carList.add(car1);
        carList.add(car2);

        cars.carsMove();

        assertTrue(car1.getPosition() >= 0 && car2.getPosition() >= 0);
    }

    @Test
    void Car_랭킹_확인_테스트() {
        List<Car> carList = new ArrayList<>();
        Cars cars = new Cars(carList);
        carList.add(new Car("car1"));
        carList.add(new Car("car2"));

        carList.get(0).carMovePosition(5);

        assertAll("Winners",
                () -> {
                    List<String> winners = cars.carRank();
                    assertEquals(1, winners.size());
                    assertEquals("car1", winners.get(0));
                }
        );
    }
}

