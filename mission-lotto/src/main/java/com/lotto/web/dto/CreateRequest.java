package com.lotto.web.dto;

import com.lotto.web.entity.User;

public record CreateRequest(String name, int money) {

    public User toUserEntity() {
        return new User(null, name, money, 0);
    }
}
