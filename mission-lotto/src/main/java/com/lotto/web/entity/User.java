package com.lotto.web.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "LottoUser")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private int money;
    @Column
    private int lottoCount;
    @Column
    private int winning;

    public User(Long id, String name, int money, int lottoCount, int winning) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.lottoCount = lottoCount;
        this.winning = winning;
    }

    public User(Long id, String name, int money, int lottoCount) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.lottoCount = lottoCount;
    }

    public User() {
    }
}
