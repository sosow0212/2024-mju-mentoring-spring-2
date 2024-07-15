package domain;

import com.racing.common.domain.Cars;
import com.racing.common.domain.vo.Name;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
}
