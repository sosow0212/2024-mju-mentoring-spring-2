package com.lotto.web.member.service;

import com.lotto.web.member.service.exception.NotFoundMemberException;
import com.lotto.web.member.dto.CreateRequest;
import com.lotto.web.member.entity.Member;
import com.lotto.web.member.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
@Transactional
class MemberServiceTest {

    @Autowired
    private MemberService memberService;
    @Autowired
    private MemberRepository memberRepository;
    private Member member;
    @BeforeEach
    void setUp(){
        member = new Member("jay", 5000);
        memberRepository.save(member);
    }

    @Test
    @DisplayName("Member를 생성한다.")
    void createMember() {
        // given
        CreateRequest createRequest = new CreateRequest("nana", 5000);
        memberService.createMember(createRequest);
        int expected = 2;

        // when
        int actual = memberRepository.findAll().size();

        // then
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Lotto를 구매하여 member 상태를 업데이트 한다.")
    void buyLotto(){
        // given
        memberService.buyLotto(member.getId(), 3);
        int expectedLottoCount = 3;
        int expectedMoney = 2000;

        // when
        int actualLottoCount = member.getLottoCount();
        int actualMoney = member.getMoney();

        // then
        assertEquals(expectedLottoCount, actualLottoCount);
        assertEquals(expectedMoney, actualMoney);
    }

    @Test
    @Transactional(readOnly = true)
    @DisplayName("잘못된 유저 조회로 예외 발생시킨다.")
    void findUser_exception(){
        // given
        String expected = "유저 없음.";

        // when
        NotFoundMemberException actual = assertThrows(NotFoundMemberException.class, () -> memberService.findUser(3L));

        // then
        assertEquals(expected, actual.getMessage());
    }

    @Test
    @Transactional(readOnly = true)
    @DisplayName("모든 유저를 반환한다.")
    void findAllUsers(){
        // given
        int expected = 1;

        // when
        int actual = memberService.findAllUsers().memberResponses().size();

        // then
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("당첨금을 저장한다.")
    void saveWinning(){
        // given
        memberService.saveWinning(member, 3);
        int expected = 5000;

        // when
        int actual = member.getWinning();

        // then
        assertEquals(expected, actual);
    }
}
