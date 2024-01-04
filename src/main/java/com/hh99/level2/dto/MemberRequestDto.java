package com.hh99.level2.dto;

import lombok.Getter;

@Getter
public class MemberRequestDto {
    private Long id;
    private String name;
    private String gender;
    private String idNumber;
    private String phone;
    private String address;
    private int penalty;
}
