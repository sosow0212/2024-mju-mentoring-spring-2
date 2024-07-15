package domain;

import com.racing.common.domain.CarNameParser;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarNameParserTest {

    @Test
    @DisplayName("올바르게 차 이름 입력했을 경우 테스트")
    void getCarNames_correct() {
        // given
        String carNames = "aaa,bbb,ccc";
        CarNameParser carNameParser = new CarNameParser(carNames);
        int expected = 3;

        // when
        int actual = carNameParser.getCarNames().size();

        // then
        assertEquals(expected, actual);
    }
}
