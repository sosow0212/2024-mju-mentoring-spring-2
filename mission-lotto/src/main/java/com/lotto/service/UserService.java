package com.lotto.service;

import com.lotto.entity.User;
import com.lotto.repository.UserRepository;
import com.lotto.service.exception.InvalidUser;
import com.lotto.service.exception.NotFoundUserException;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;


    @Transactional
    public User createUser(String userName, int balance) {
        if (userName == null || userName.isEmpty() || balance < 0) {
            throw new InvalidUser();
        }
        User user = new User(userName, balance);
        return userRepository.save(user);
    }

    @Transactional
    public User findByUserId(Long userId) {
        return userRepository.findById(userId)
                .orElseThrow(NotFoundUserException::new);
    }
}
