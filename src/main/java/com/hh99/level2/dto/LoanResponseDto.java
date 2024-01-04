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
    private LocalDate loanDate;
    private LocalDate returnDate;
    private boolean returnStatus;
    private boolean loanStatus;

    public LoanResponseDto(Loan loan) {
        this.id = loan.getId();
        this.book = loan.getBook();
        this.member = loan.getMember();
        this.loanDate = loan.getLoanDate();
        this.loanStatus = loan.isLoanStatus();
        this.returnDate = loan.getReturnDate();
        this.returnStatus = loan.isReturnStatus();
    }
}
