package com.hh99.level2.dto;

import com.hh99.level2.entity.Book;
import com.hh99.level2.entity.Member;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class LoanRequestDto {
    private Book book;
    private Member member;
    private boolean returnStatus;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public Long getBookId() {
        return book.getId();
    }

    public Long getMemberId() {
        return member.getId();
    }
}
