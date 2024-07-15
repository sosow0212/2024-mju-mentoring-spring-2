package com.racing.common.domain.vo;

import com.racing.console.view.exception.NullInputException;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NameTest {

    @Test
    void 자동차값이_널값일때_예외테스트() {

        // given
        String carNames = "";

        // when&then
        assertThatThrownBy(() -> Name.from(carNames))
                .isInstanceOf(NullInputException.class); // Expect NullInputException
    }
}
