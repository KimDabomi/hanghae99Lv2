package com.hh99.level2.entity;

import com.hh99.level2.dto.MemberRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Table(name = "members")
@NoArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "gender", nullable = false)
    private String gender;

    @Column(name = "id_number", nullable = false)
    private String idNumber;

    @Column(name = "phone", nullable = false)
    private String phone;

    @Column(name = "address", nullable = false)
    private String address;

    @Column(name = "penalty")
    private int penalty;

    public void setPenalty(int penalty) {
        this.penalty = penalty;
    }

    public Member(MemberRequestDto requestDto) {
        this.name = requestDto.getName();
        this.gender = requestDto.getGender();
        this.idNumber = requestDto.getIdNumber();
        this.phone = requestDto.getPhone();
        this.address = requestDto.getAddress();
        this.penalty = requestDto.getPenalty();
    }
}
