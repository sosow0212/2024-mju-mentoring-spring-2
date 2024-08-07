package com.lotto.web.member.entity;

import com.lotto.web.member.entity.exception.NotFoundMoneyException;
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

    public Member(String name, int money) {
        this.name = name;
        this.money = money;
    }

    protected Member() {
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }

    public int getLottoCount() {
        return lottoCount;
    }

    public int getWinning() {
        return winning;
    }

    public void buyLotto(int count) {
        validateLottoMoney(count);
        this.money -= count * 1000;
        this.lottoCount += count;
    }

    public void setWinning(int winning) {
        this.winning = winning;
    }

    private void validateLottoMoney(int count) {
        if (money < count * 1000) {
            throw new NotFoundMoneyException();
        }
    }
}
