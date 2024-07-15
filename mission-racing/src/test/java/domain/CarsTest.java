package domain;

import com.racing.console.domain.Cars;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarsTest {

    @Test
    @DisplayName("차 개수 반환 테스트")
    void getCars() {
        // given
        List<String> carNames = List.of("aa","bb","cc");
        Cars cars = new Cars(carNames);
        int expected = 3;

        // when
        int actual = cars.getCars().size();

        // then
        assertEquals(expected, actual);
    }
}
