package com.lotto.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "LottoTicket")
public class LottoTicket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Long userId;

    @Column
    private String userName;

    @ElementCollection
    @Column(name = "numbers")
    private List<Integer> numbers;

    @Column
    private boolean winner;

    public LottoTicket(Long userId, String userName, List<Integer> numbers, boolean winner) {
        this.userId = userId;
        this.userName = userName;
        this.numbers = numbers;
        this.winner = winner;
    }
}
