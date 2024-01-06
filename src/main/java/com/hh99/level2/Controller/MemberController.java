package com.hh99.level2.controller;

import com.hh99.level2.dto.MemberRequestDto;
import com.hh99.level2.dto.MemberResponseDto;
import com.hh99.level2.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class MemberController {
    private final MemberService  memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/members")
    public MemberResponseDto createMember(@RequestBody MemberRequestDto requestDto) {
        return memberService.createMember(requestDto);
    }

    @GetMapping("/members/{id}")
    public MemberResponseDto getMember(@PathVariable Long id) {
        return memberService.getMember(id);
    }
}
