package com.racing;

import com.racing.exception.CarNotFoundException;
import com.racing.exception.NameLengthException;
import com.racing.model.Cars;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

public class CarsTest {

    @Test
    void 이름이_6자_이상일_경우_오류_발생() {
        String inputName = "minji,haerin";

        assertThatThrownBy(() -> new Cars(inputName))
                .isInstanceOf(NameLengthException.class)
                .hasMessageContaining("이름은 5자 이내로 입력 가능합니다.");
    }

    @Test
    void 생성된_Car_개수_테스트() {
        String inputName = "minji,hanni,hyein";
        Cars cars = new Cars(inputName);

        int expected = 3;
        int actual = cars.getCarList().size();

        assertEquals(expected, actual);
    }

    @Test
    void Cars_이동_테스트() {
        String inputName = "car1,car2";
        Cars cars = new Cars(inputName);

        cars.moveCars();

        assertTrue(cars.getCarList().get(0).getPosition() >= 0 && cars.getCarList().get(1).getPosition() >= 0);
    }

    @Test
    void Car_랭킹_확인_테스트() {
        String inputNames = "car1,car2";
        Cars cars = new Cars(inputNames);

        cars.findCarByName("car1").movePosition(5);

        assertAll("Winners",
                () -> {
                    List<String> winners = cars.rankCars();
                    assertEquals(1, winners.size());
                    assertEquals("car1", winners.get(0));
                }
        );
    }

    @Test
    void Car_이름으로_조회_실패할_경우_오류_발생(){
        String inputNames="car1,car2";
        Cars cars=new Cars(inputNames);

        assertThatThrownBy(() -> cars.findCarByName("car3"))
                .isInstanceOf(CarNotFoundException.class)
                .hasMessageContaining("차가 존재하지 않습니다.");
    }
}
