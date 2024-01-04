package com.hh99.level2.dto;

import com.hh99.level2.entity.Member;
import lombok.Getter;

@Getter
public class MemberResponseDto {
    private Long id;
    private String name;
    private String gender;
    private String phone;
    private String address;
    private int penalty;

    public MemberResponseDto(Member member) {
        this.id = member.getId();
        this.name = member.getName();
        this.gender = member.getGender();
        this.phone = member.getPhone();
        this.address = member.getAddress();
        this.penalty = member.getPenalty();
    }
}
