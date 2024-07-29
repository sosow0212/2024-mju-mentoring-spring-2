package com.lotto.web.repository;

import com.lotto.web.entity.LottoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LottoRepository extends JpaRepository<LottoEntity, Long> {
}
