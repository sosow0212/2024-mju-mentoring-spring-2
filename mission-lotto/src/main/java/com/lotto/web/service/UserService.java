package com.lotto.web.service;

import com.lotto.web.domain.exception.CustomErrorCode;
import com.lotto.web.domain.exception.CustomException;
import com.lotto.web.dto.CreateRequest;
import com.lotto.web.dto.LottoRequest;
import com.lotto.web.entity.User;
import com.lotto.web.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.security.PublicKey;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(CreateRequest createRequest) {
        User user = createRequest.toUserEntity();
        userRepository.save(user);
    }

    public int getUserMoney(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new CustomException(CustomErrorCode.EXCEPTION_USER));
        return user.getMoney();
    }

    public User getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new CustomException(CustomErrorCode.EXCEPTION_USER));
    }

    public void buyLotto(LottoRequest lottoRequest){
        User user = getUser(lottoRequest.getUserId());
        int money = user.getMoney() - lottoRequest.getCount() * 1000;
        User updatedUser = new User(user.getId(), user.getName(), money, lottoRequest.getCount());
        userRepository.save(updatedUser);
    }
}
