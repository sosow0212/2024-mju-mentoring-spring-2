package com.lotto.web.member.mapper;

import com.lotto.web.member.dto.CreateRequest;
import com.lotto.web.member.dto.MemberResponse;
import com.lotto.web.member.dto.MemberResponses;
import com.lotto.web.member.entity.Member;

import java.util.List;

public class MemberMapper {

    public static Member toMember(CreateRequest createRequest) {
        return new Member(createRequest.name(), createRequest.money());
    }

    public static MemberResponse toMemberResponse(Member member) {
        return new MemberResponse(member.getId(), member.getName(), member.getLottoCount(), member.getWinning());
    }

    public static MemberResponses toMemberResponses(List<MemberResponse> memberResponses) {
        return MemberResponses.memberResponses(memberResponses);
    }
}
