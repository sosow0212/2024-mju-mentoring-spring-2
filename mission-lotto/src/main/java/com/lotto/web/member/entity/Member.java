package com.lotto.web.member.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "LottoUser")
public class Member {

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

    public Member(Long id, String name, int money, int lottoCount, int winning) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.lottoCount = lottoCount;
        this.winning = winning;
    }

    public Member(Long id, String name, int money, int lottoCount) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.lottoCount = lottoCount;
    }

    protected Member() {
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

    public int getLottoCount(){
        return lottoCount;
    }

    public int getWinning(){
        return winning;
    }
}
