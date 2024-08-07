package com.lotto.web.member.service;

import com.lotto.web.lotto.domain.LottoPrice;
import com.lotto.web.member.dto.CreateRequest;
import com.lotto.web.member.dto.MemberResponse;
import com.lotto.web.member.dto.MemberResponses;
import com.lotto.web.member.entity.Member;
import com.lotto.web.member.mapper.MemberMapper;
import com.lotto.web.member.repository.MemberRepository;
import com.lotto.web.member.service.exception.NotFoundMemberException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Transactional
    public MemberResponse createMember(CreateRequest createRequest) {
        Member member = MemberMapper.toMember(createRequest);
        memberRepository.save(member);
        return MemberMapper.toMemberResponse(member);
    }

    @Transactional
    public void buyLotto(Long id, int count) {
        Member member = findUser(id);
        member.buyLotto(count);
    }

    @Transactional(readOnly = true)
    public Member findUser(Long id) {
        return memberRepository.findById(id)
                .orElseThrow(NotFoundMemberException::new);
    }

    @Transactional(readOnly = true)
    public MemberResponses findAllUsers() {
        List<Member> members = memberRepository.findAll();
        List<MemberResponse> memberResponses = members.stream()
                .map(MemberMapper::toMemberResponse)
                .toList();
        return MemberMapper.toMemberResponses(memberResponses);
    }

    @Transactional
    public void saveWinning(Member member, int count) {
        int winning = member.getWinning() + LottoPrice.getLottoPrice(count);
        member.setWinning(winning);
    }
}
