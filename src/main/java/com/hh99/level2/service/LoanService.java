package com.hh99.level2.service;

import com.hh99.level2.dto.LoanHistoryDto;
import com.hh99.level2.dto.LoanRequestDto;
import com.hh99.level2.dto.LoanResponseDto;
import com.hh99.level2.entity.Book;
import com.hh99.level2.entity.Loan;
import com.hh99.level2.entity.Member;
import com.hh99.level2.repository.BookRepository;
import com.hh99.level2.repository.LoanRepository;
import com.hh99.level2.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

    public LoanResponseDto createLoan(LoanRequestDto requestDto) {
        Long bookId = requestDto.getBookId();
        Long memberId = requestDto.getMemberId();

        Book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException("Book not found"));
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("Member not found"));

        List<Loan> existingBookLoans = loanRepository.findByBookAndReturnStatusFalse(book);
        List<Loan> existingMemberLoans = loanRepository.findByMemberAndReturnStatusFalse(member);

        if (!existingBookLoans.isEmpty()) {
            throw new IllegalArgumentException("현재 대출 상태인 도서입니다.");
        }

        if (!existingMemberLoans.isEmpty()) {
            throw new IllegalArgumentException("반납하지 않은 도서가 있기 때문에, 대출이 불가능합니다.");
        }

        Loan loan = new Loan();
        loan.setBook(book, member);
        Loan saveLoan = loanRepository.save(loan);
        return new LoanResponseDto(saveLoan, "[SUCCESS] 도서 대출이 완료되었습니다.");
    }

    public List<LoanHistoryDto> getLoanHistoryForMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회원입니다."));

        List<Loan> loanHistory = loanRepository.findByMemberAndReturnStatusOrderByLoanDateAsc(member, false);

        return loanHistory.stream()
                .map(loan -> new LoanHistoryDto(
                        loan.getMember().getName(),
                        loan.getMember().getPhone(),
                        loan.getBook().getTitle(),
                        loan.getBook().getAuthor(),
                        loan.getLoanDate()
                ))
                .collect(Collectors.toList());
    }
}
