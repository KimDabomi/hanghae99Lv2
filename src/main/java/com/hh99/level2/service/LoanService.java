package com.hh99.level2.service;

import com.hh99.level2.dto.LoanHistoryDto;
import com.hh99.level2.dto.LoanRequestDto;
import com.hh99.level2.dto.LoanResponseDto;
import com.hh99.level2.entity.Book;
import com.hh99.level2.entity.Loan;
import com.hh99.level2.entity.Member;
import com.hh99.level2.message.ErrorMessage;
import com.hh99.level2.message.SuccessMessage;
import com.hh99.level2.repository.BookRepository;
import com.hh99.level2.repository.LoanRepository;
import com.hh99.level2.repository.MemberRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LoanService {
    private static final int ONE_DAY = 1;
    private static final int ZERO = 0;
    private static final int TWO_WEEKS = 14;
    private final LoanRepository loanRepository;
    private final BookRepository bookRepository;
    private final MemberRepository memberRepository;


    public LoanResponseDto createLoan(LoanRequestDto requestDto) {
        Long bookId = requestDto.getBookId();
        Long memberId = requestDto.getMemberId();

        Book book = bookRepository.findById(bookId).orElseThrow(() -> new IllegalArgumentException(ErrorMessage.EXIST_BOOK_ERROR_MESSAGE.getErrorMessage()));
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException(ErrorMessage.EXIST_MEMBER_ERROR_MESSAGE.getErrorMessage()));

        List<Loan> existingBookLoans = loanRepository.findByBookAndReturnStatusFalse(book);
        if (!existingBookLoans.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.LOAN_STATUS_BOOK_ERROR_MESSAGE.getErrorMessage());
        }
        
        List<Loan> existingMemberLoans = loanRepository.findByMemberAndReturnStatusFalse(member);
        if (!existingMemberLoans.isEmpty()) {
            throw new IllegalArgumentException(ErrorMessage.RETURN_STATUS_BOOK_ERROR_MESSAGE.getErrorMessage());
        }

        Loan loan = new Loan();
        loan.setBook(book, member);
        Loan saveLoan = loanRepository.save(loan);
        return new LoanResponseDto(saveLoan, SuccessMessage.LOAN_SUCCESS_MESSAGE.getSuccessMessage());
    }

    public List<LoanHistoryDto> getLoanHistoryForMember(Long memberId) {
        Member member = memberRepository.findById(memberId).orElseThrow(() -> new IllegalArgumentException(ErrorMessage.EXIST_MEMBER_ERROR_MESSAGE.getErrorMessage()));

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

    @Transactional
    public void getLoanOverdueBooks(){
        List<Loan> loanList = loanRepository.findAll()
                .stream()
                .filter(loan -> Period.between(loan.getLoanDate(), LocalDate.now()).getDays() >= ONE_DAY)
                .toList();

        loanList.forEach(
                loan -> {
                    if(loan.getMember().getPenalty() <= ZERO){
                        loan.getMember().setPenalty(TWO_WEEKS);
                    } else {
                        int penalty = loan.getMember().getPenalty();
                        loan.getMember().setPenalty(penalty - 1);
                    }
                }
        );
    }
}
