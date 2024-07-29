package com.lotto.web.dto;

import com.lotto.web.entity.User;

public class CreateRequest {

    private final String name;
    private final int money;

    public CreateRequest(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public User toUserEntity() {
        return new User(null, name, money, 0);
    }
}
