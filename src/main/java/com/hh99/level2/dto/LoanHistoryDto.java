package com.hh99.level2.dto;

import lombok.Getter;

import java.time.LocalDate;

@Getter
public class LoanHistoryDto {
    private final String memberName;
    private final String memberPhoneNumber;
    private final String bookTitle;
    private final String bookAuthor;
    private final LocalDate loanDate;

    public LoanHistoryDto(String memberName, String memberPhoneNumber, String bookTitle, String bookAuthor, LocalDate loanDate) {
        this.memberName = memberName;
        this.memberPhoneNumber = memberPhoneNumber;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.loanDate = loanDate;
    }
}
