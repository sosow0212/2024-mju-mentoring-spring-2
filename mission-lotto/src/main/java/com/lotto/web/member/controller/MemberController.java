package com.lotto.web.member.controller;

import com.lotto.web.member.dto.CreateRequest;
import com.lotto.web.member.dto.MemberResponse;
import com.lotto.web.member.dto.MemberResponses;
import com.lotto.web.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;

@RestController
@RequestMapping("/api")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/members")
    public ResponseEntity<Void> createUser(@RequestBody CreateRequest createRequest) {
        MemberResponse memberResponse = memberService.createMember(createRequest);
        URI location = URI.create("/api/members/" + memberResponse.id());
        return ResponseEntity.created(location).build();
    }

    @GetMapping("/members")
    public ResponseEntity<MemberResponses> showUsers() {
        return ResponseEntity.status(HttpStatus.OK).body(memberService.findAllUsers());
    }
}
