package domain;

import FakeRandomNumber.FakeRandomNumber;
import com.racing.common.domain.Cars;
import com.racing.common.domain.CreateRandomNumber;
import com.racing.common.domain.vo.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    @DisplayName("차 개수 반환 테스트")
    void getCars() {
        // given
        List<Name> carNames = List.of(new Name("aa"), new Name("bb"), new Name("cc"));
        Cars cars = new Cars(carNames);
        int expected = 3;

        // when
        int actual = cars.getCars().size();

        // then
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Winner 뽑는 메서드 테스트")
    void getWinner() {
        // given
        List<Name> carNames = List.of(new Name("aa"), new Name("bb"), new Name("cc"));
        Cars cars = new Cars(carNames);
        CreateRandomNumber createRandomNumber = new FakeRandomNumber();
        cars.getCars().get(0).moveCar(createRandomNumber);
        int expected = 1;

        // when
        int actual = cars.getWinner().size();

        // then
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("모든 차 상태 보는 메서드 테스트")
    void getStatus() {
        // given
        List<Name> carNames = List.of(new Name("aa"), new Name("bb"), new Name("cc"));
        Cars cars = new Cars(carNames);
        List<Object> status = cars.getStatus();
        Object expected = Map.of("aa", 0);

        // when
        Object actual = status.get(0);

        // then
        assertEquals(expected, actual);
    }
}
