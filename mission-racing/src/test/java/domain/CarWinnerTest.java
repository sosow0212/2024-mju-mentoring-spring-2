package domain;

import FakeRandomNumber.FakeRandomNumber;
import com.racing.console.domain.Car;
import com.racing.console.domain.CarWinner;
import com.racing.console.domain.Cars;
import com.racing.console.domain.CreateRandomNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarWinnerTest {

    @Test
    @DisplayName("레이싱 우승자 반환 테스트")
    void getCarWinner() {
        // given
        List<String> carNames = List.of("aa", "bb", "cc");
        Cars cars = new Cars(carNames);
        CreateRandomNumber createRandomNumber = new FakeRandomNumber();
        List<Integer> moveCounts = new ArrayList<>();
        for (Car car : cars.getCars()) {
            car.moveCar(createRandomNumber);
            moveCounts.add(car.getMoveCount());
        }
        CarWinner carWinner = new CarWinner(carNames, moveCounts);
        List<String> expected = List.of("aa", "bb", "cc");

        // when
        List<String> actual = carWinner.getCarWinner();

        // then
        assertEquals(expected, actual);
    }
}
