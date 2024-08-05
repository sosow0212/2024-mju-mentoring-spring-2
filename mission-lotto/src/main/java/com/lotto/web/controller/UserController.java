package com.lotto.web.controller;

import com.lotto.web.dto.CreateRequest;
import com.lotto.web.dto.UserResponse;
import com.lotto.web.entity.User;
import com.lotto.web.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/users")
    public ResponseEntity<Void> createUser(@RequestBody CreateRequest createRequest){
        User user = userService.createUser(createRequest);
        URI location = URI.create("/api/users/"+ user.getId());
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserResponse>> showUsers(){
        return ResponseEntity.status(HttpStatus.OK).body(userService.getAllUsers());
    }
}
