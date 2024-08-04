package com.lotto.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;


@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "lotto_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(name = "NAME")
    private String userName;

    @Column
    private int money;

    @OneToMany(mappedBy = "user")
    private List<UserLotto> userLotto = new ArrayList<>();

    public void addUserLotto(UserLotto userLotto) {
        if (this.userLotto == null) {
            this.userLotto = new ArrayList<>();
        }
        userLotto.setUser(this);
        this.userLotto.add(userLotto);
    }

    public void subtractMoney(int amount) {
        this.money -= amount;
    }
}
