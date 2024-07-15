package domain;

import FakeRandomNumber.FakeRandomNumber;
import com.racing.common.domain.Car;
import com.racing.common.domain.CarWinner;
import com.racing.common.domain.Cars;
import com.racing.common.domain.CreateRandomNumber;
import com.racing.common.domain.vo.Name;
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
        List<Name> carNames = List.of(new Name("aa"), new Name("bb"), new Name("cc"));
        Cars cars = new Cars(carNames);
        CreateRandomNumber createRandomNumber = new FakeRandomNumber();
        List<Integer> moveCounts = new ArrayList<>();
        List<String> names = new ArrayList<>();
        for (Car car : cars.getCars()) {
            car.moveCar(createRandomNumber);
            moveCounts.add(car.getMoveCount());
            names.add(car.getCarName());
        }
        CarWinner carWinner = new CarWinner(names, moveCounts);
        List<String> expected = List.of("aa", "bb", "cc");

        // when
        List<String> actual = carWinner.getCarWinner();

        // then
        assertEquals(expected, actual);
    }
}
