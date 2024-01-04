package com.hh99.level2.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Table(name = "loans")
public class Loan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(name = "loan_date", nullable = false)
    private LocalDate loanDate;

    @Column(name = "loan_status", nullable = false)
    private boolean loanStatus;

    @Setter
    @Column(name = "return_date")
    private LocalDate returnDate;

    @Setter
    @Column(name = "return_status", nullable = false)
    private boolean returnStatus;

    public void setBook(Book book, Member member) {
        this.book = book;
        this.member = member;
        this.loanDate = LocalDate.now();
        this.loanStatus = true;
        this.returnStatus = false;
    }

    public boolean isAvailable() {
        return !loanStatus;
    }
}
