package com.User.service;

import com.User.controller.dto.CreateUserRequest;
import com.User.domain.entity.User;
import com.User.domain.repository.UserRepository;
import com.User.service.exception.NegativeAmountException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void createUser(CreateUserRequest request) {
        validateBalanceException(request.balance());
        User user = User
                .builder()
                .userName(request.userName())
                .balance(request.balance())
                .build();
        userRepository.save(user);
    }

    private static void validateBalanceException(final int balance) {
        if (balance < 0) {
            throw new NegativeAmountException();
        }
    }


//
//    public User getUserById(Long userId) {
//        return userRepository
//                .findById(userId)
//                .orElseThrow(NotFoundUserException::new);
//    }
//
//    public User getAllUsers() {
//
//    }
//
//    public void updateUserBalance(Long userId, int ticketCount) {
//
//    }
}
