package com.lotto.controller;

import com.lotto.controller.dto.UserRequest;
import com.lotto.controller.dto.UserResponse;
import com.lotto.entity.User;
import com.lotto.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest userRequest) {
        User user = userService.createUser(userRequest.getUserName(), userRequest.getBalance());
        return new UserResponse(user.getUserId(), user.getUserName(), user.getBalance());
    }

    @GetMapping("/{userId}")
    public UserResponse getUser(@PathVariable Long userId) {
        User user = userService.findByUserId(userId);
        return new UserResponse(user.getUserId(), user.getUserName(), user.getBalance());
    }
}
