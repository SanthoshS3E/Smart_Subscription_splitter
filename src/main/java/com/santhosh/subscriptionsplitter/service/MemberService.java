package com.santhosh.subscriptionsplitter.service;

import com.santhosh.subscriptionsplitter.model.Member;
import com.santhosh.subscriptionsplitter.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {

    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    public Member addMember(Member member) {
        return memberRepository.save(member);
    }

    public List<Member> getMembersByGroupId(Long groupId) {
        return memberRepository.findAll()
                .stream()
                .filter(m -> m.getGroupId().equals(groupId))
                .toList();
    }
}
