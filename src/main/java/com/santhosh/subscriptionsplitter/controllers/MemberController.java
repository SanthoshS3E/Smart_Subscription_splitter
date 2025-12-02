package com.santhosh.subscriptionsplitter.controllers;

import com.santhosh.subscriptionsplitter.model.Member;
import com.santhosh.subscriptionsplitter.service.MemberService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping
    public Member addMember(@RequestBody Member member) {
        return memberService.addMember(member);
    }

    @GetMapping("/group/{groupId}")
    public List<Member> getMembersByGroup(@PathVariable Long groupId) {
        return memberService.getMembersByGroupId(groupId);
    }
}
