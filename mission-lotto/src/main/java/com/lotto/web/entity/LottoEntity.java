package com.lotto.web.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "LottoTicket")
@Getter
public class LottoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column
    private String lottoNumber;
    @Column
    private boolean win;

    public LottoEntity(Long id, User user, String lottoNumber, boolean win) {
        this.id = id;
        this.user = user;
        this.lottoNumber = lottoNumber;
        this.win = win;
    }

    public LottoEntity() {
    }

    public boolean getWin() {
        return win;
    }
}
