package domain;

import FakeRandomNumber.FakeRandomNumber;
import com.racing.common.domain.CreateRandomNumber;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarRandomNumberTest {

    @Test
    @DisplayName("자동차 랜덤 넘버 생성 인터페이스 테스트")
    void generateRandomNumber() {
        // given
        CreateRandomNumber createRandomNumber = new FakeRandomNumber();
        int expected = 4;

        // when
        int actual = createRandomNumber.generateRandomNumber();

        // then
        assertEquals(expected, actual);
    }
}
