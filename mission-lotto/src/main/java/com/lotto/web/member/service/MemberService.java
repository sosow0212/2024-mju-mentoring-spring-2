package com.lotto.web.member.service;

import com.lotto.web.lotto.domain.LottoPrice;
import com.lotto.web.lotto.domain.exception.CustomErrorCode;
import com.lotto.web.lotto.domain.exception.CustomException;
import com.lotto.web.member.dto.CreateRequest;
import com.lotto.web.lotto.dto.LottoRequest;
import com.lotto.web.member.dto.MemberResponse;
import com.lotto.web.member.entity.Member;
import com.lotto.web.member.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public MemberResponse createMember(CreateRequest createRequest) {
        Member member = createRequest.toUserEntity();
        memberRepository.save(member);
        return new MemberResponse(member.getId(), member.getName(), member.getLottoCount(), member.getWinning());
    }

    public int getUserMoney(Long id) {
        Member member = memberRepository.findById(id)
                .orElseThrow(() -> new CustomException(CustomErrorCode.EXCEPTION_USER));
        return member.getMoney();
    }

    public Member getUser(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(() -> new CustomException(CustomErrorCode.EXCEPTION_USER));
    }

    public void updateMoney(LottoRequest lottoRequest) {
        Member member = getUser(lottoRequest.userId());
        int money = member.getMoney() - lottoRequest.count() * 1000;
        Member updatedMember = new Member(member.getId(), member.getName(), money, member.getLottoCount() + lottoRequest.count());
        memberRepository.save(updatedMember);
    }

    public List<MemberResponse> getAllUsers() {
        List<Member> members = memberRepository.findAll();
        validateUserExist(members);
        List<MemberResponse> memberResponse = new ArrayList<>();
        for (Member member : members) {
            memberResponse.add(new MemberResponse(member.getId(), member.getName(), member.getLottoCount(), member.getWinning()));
        }
        return memberResponse;
    }

    public void saveWinning(Member member, int count) {
        int winning = LottoPrice.getLottoPrice(count);
        Member updatedMember = new Member(member.getId(), member.getName(), member.getMoney(), member.getLottoCount(), winning);
        memberRepository.save(updatedMember);
    }

    private void validateUserExist(List<Member> members) {
        if (members.isEmpty()) {
            throw new CustomException(CustomErrorCode.EXCEPTION_USER);
        }
    }
}
