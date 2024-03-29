package com.hh99.level2.service;

import com.hh99.level2.dto.MemberRequestDto;
import com.hh99.level2.dto.MemberResponseDto;
import com.hh99.level2.entity.Member;
import com.hh99.level2.message.ErrorMessage;
import com.hh99.level2.repository.MemberRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public MemberResponseDto createMember(MemberRequestDto requestDto) {
        Member member = new Member(requestDto);
        Member saveMember = memberRepository.save(member);
        return new MemberResponseDto(saveMember);
    }

    public MemberResponseDto getMember(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new EntityNotFoundException(ErrorMessage.EXIST_MEMBER_ERROR_MESSAGE.getErrorMessage()));
        member.getIdNumber();
        return new MemberResponseDto(member);
    }
}
