package com.lotto.web.service;

import com.lotto.web.domain.LottoPrice;
import com.lotto.web.domain.exception.CustomErrorCode;
import com.lotto.web.domain.exception.CustomException;
import com.lotto.web.dto.CreateRequest;
import com.lotto.web.dto.LottoRequest;
import com.lotto.web.dto.UserResponse;
import com.lotto.web.entity.User;
import com.lotto.web.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User createUser(CreateRequest createRequest) {
        User user = createRequest.toUserEntity();
        userRepository.save(user);
        return user;
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

    public void updateMoney(LottoRequest lottoRequest) {
        User user = getUser(lottoRequest.userId());
        int money = user.getMoney() - lottoRequest.count() * 1000;
        User updatedUser = new User(user.getId(), user.getName(), money, user.getLottoCount() + lottoRequest.count());
        userRepository.save(updatedUser);
    }

    public List<UserResponse> getAllUsers() {
        List<User> users = userRepository.findAll();
        validateUserExist(users);
        List<UserResponse> userResponses = new ArrayList<>();
        for (User user : users) {
            userResponses.add(new UserResponse(user.getName(), user.getLottoCount(), user.getWinning()));
        }
        return userResponses;
    }

    public void saveWinning(User user, int count){
        int winning = LottoPrice.getLottoPrice(count);
        User updatedUser = new User(user.getId(),user.getName(),user.getMoney(), user.getLottoCount(), winning);
        userRepository.save(updatedUser);
    }

    private void validateUserExist(List<User> users) {
        if (users.isEmpty()) {
            throw new CustomException(CustomErrorCode.EXCEPTION_USER);
        }
    }
}
