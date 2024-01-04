package com.hh99.level2.service;

import com.hh99.level2.dto.LoanRequestDto;
import com.hh99.level2.dto.LoanResponseDto;
import com.hh99.level2.entity.Book;
import com.hh99.level2.entity.Loan;
import com.hh99.level2.entity.Member;
import com.hh99.level2.repository.BookRepository;
import com.hh99.level2.repository.LoanRepository;
import com.hh99.level2.repository.MemberRepository;
import org.springframework.stereotype.Service;

@Service
public class LoanService {
    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;

    public LoanService(LoanRepository loanRepository, BookRepository bookRepository, MemberRepository memberRepository) {
        this.loanRepository = loanRepository;
        this.bookRepository = bookRepository;
        this.memberRepository = memberRepository;
    }

    public void createLoan(LoanRequestDto requestDto) {
        Long bookId = requestDto.getBookId();
        Long memberId = requestDto.getMemberId();

        // Book 및 Member 엔터티 조회
        Book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Book not found"));
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("Member not found"));

        // Loan 생성 및 저장
        Loan loan = new Loan();
        loan.setBook(book, member);
        loanRepository.save(loan);
    }
}
