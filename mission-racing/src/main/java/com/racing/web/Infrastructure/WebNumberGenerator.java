package com.racing.web.Infrastructure;

import com.racing.common.domain.NumberGenerator;

import org.springframework.stereotype.Component;

@Component
public class WebNumberGenerator implements NumberGenerator {
    public int generateRandom() {
        return (int) (Math.random() * 10);
    }

}
