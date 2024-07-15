package domain;

import FakeRandomNumber.FakeRandomNumber;
import com.racing.console.domain.Car;
import com.racing.console.domain.CreateRandomNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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
        String carName = "aaa";
        Car car = new Car(carName);
        String expected = "aaa";

        // when
        String actual = car.getCarName();

        // then
        assertEquals(expected, actual);
    }
}
