package com.lotto.web.repository;

import com.lotto.web.entity.LottoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LottoRepository extends JpaRepository<LottoEntity, Long> {

    List<LottoEntity> findAllByUserId(Long userId);
}
