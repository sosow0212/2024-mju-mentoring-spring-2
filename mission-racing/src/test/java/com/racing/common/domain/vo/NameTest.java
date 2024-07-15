package com.racing.common.domain.vo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NameTest {

    @Test
    @DisplayName("Name 예외처리 테스트")
    void from_generate_exception() {
        // given
        String name = "aaaaaa";
        var expected = "차 이름 너무 긺";

        // when
        RuntimeException actual = assertThrows(RuntimeException.class, () -> Name.from(name));

        // then
        assertEquals(expected, actual.getMessage());
    }
}
