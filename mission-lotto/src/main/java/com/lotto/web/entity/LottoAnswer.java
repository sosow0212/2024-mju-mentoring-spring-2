package com.lotto.web.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class LottoAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Getter
    @Column
    private String lottoAnswer;

    public LottoAnswer(Long id, String lottoAnswer) {
        this.id = id;
        this.lottoAnswer = lottoAnswer;
    }

    public LottoAnswer(){
    }
}
