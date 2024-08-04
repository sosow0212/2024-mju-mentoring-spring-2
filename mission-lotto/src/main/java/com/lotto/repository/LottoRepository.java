package com.lotto.repository;

import com.lotto.entity.UserLotto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LottoRepository extends JpaRepository<UserLotto, Long> {
    List<UserLotto> findByUser_UserName(String userName);

    Optional<UserLotto> findByLottoId(Long lottoId);
}
