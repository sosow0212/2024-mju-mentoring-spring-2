package com.lotto.web.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "LottoTicket")
public class LottoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
    @Column
    private String lottoNumber;

    public LottoEntity(Long id, User user, String lottoNumber) {
        this.id = id;
        this.user = user;
        this.lottoNumber = lottoNumber;
    }

    public LottoEntity() {
    }

    public String getLottoNumber() {
        return lottoNumber;
    }
}
