package com.lotto.web.entity;

import jakarta.persistence.*;

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

    public User(Long id, String name, int money, int lottoCount) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.lottoCount = lottoCount;
    }

    public User(){
    }

    public Long getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getMoney(){
        return money;
    }
}
