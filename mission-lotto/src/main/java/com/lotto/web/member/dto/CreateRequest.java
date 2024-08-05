package com.lotto.web.member.dto;

import com.lotto.web.member.entity.Member;

public record CreateRequest(String name, int money) {

    public Member toUserEntity() {
        return new Member(null, name, money, 0);
    }
}
