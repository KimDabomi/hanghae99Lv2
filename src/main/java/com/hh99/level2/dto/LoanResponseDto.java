package com.hh99.level2.dto;

import com.hh99.level2.entity.Book;
import com.hh99.level2.entity.Loan;
import com.hh99.level2.entity.Member;
import lombok.Getter;

import java.time.LocalDate;

@Getter
public class LoanResponseDto {
    private Long id;
    private Book book;
    private Member member;
    private boolean returnStatus;
    private LocalDate loanDate;
    private LocalDate returnDate;

    public LoanResponseDto(Loan loan) {
        this.id = loan.getId();
        this.book = loan.getBook();
        this.member = loan.getMember();
        this.returnStatus = loan.isReturnStatus();
        this.loanDate = loan.getLoanDate();
        this.returnDate = loan.getReturnDate();
    }
}
