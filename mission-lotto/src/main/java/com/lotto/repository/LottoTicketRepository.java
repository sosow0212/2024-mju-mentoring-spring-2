package com.lotto.repository;

import com.lotto.entity.LottoTicket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LottoTicketRepository extends JpaRepository<LottoTicket, Long> {
    List<LottoTicket> findByUserId(Long userId);
}
