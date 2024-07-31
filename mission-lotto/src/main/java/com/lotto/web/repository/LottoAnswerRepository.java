package com.lotto.web.repository;

import com.lotto.web.entity.LottoAnswer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface LottoAnswerRepository extends JpaRepository<LottoAnswer, Long> {

   Optional<LottoAnswer> findFirstByOrderById();
}
