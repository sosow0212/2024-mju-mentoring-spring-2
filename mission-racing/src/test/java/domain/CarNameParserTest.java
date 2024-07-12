package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarNameParserTest {

    @Nested
    @DisplayName("차 이름 입력 테스트")
    class getCarNames {

        @Test
        @DisplayName("올바르게 차 이름 입력했을 경우 테스트")
        void getCarNames_correct() {
            // given
            String carNames = "aaa,bbb,ccc";
            CarNameParser carNameParser = new CarNameParser(carNames);
            List<String> expected = List.of("aaa", "bbb", "ccc");

            // when
            List<String> actual = carNameParser.getCarNames();

            // then
            assertEquals(expected, actual);
        }

        @Test
        @DisplayName("6글자 이상 차 이름 입력했을 경우 테스트_예외처리")
        void getCarNames_generate_exception() {
            // given
            String carName = "aaaaaa";
            var expected = "차 이름 너무 긺";

            // when
            RuntimeException actual = assertThrows(RuntimeException.class, () -> new CarNameParser(carName));

            // then
            assertEquals(expected, actual.getMessage());
        }
    }
}
