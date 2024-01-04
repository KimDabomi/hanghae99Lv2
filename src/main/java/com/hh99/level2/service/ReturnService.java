package com.hh99.level2.service;

import com.hh99.level2.dto.LoanRequestDto;
import com.hh99.level2.dto.LoanResponseDto;
import com.hh99.level2.entity.Book;
import com.hh99.level2.entity.Loan;
import com.hh99.level2.entity.Member;
import com.hh99.level2.repository.ReturnRepository;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@RequiredArgsConstructor
public class ReturnService {
    private final ReturnRepository returnRepository;

    // 선택한 도서 반납
    @Transactional
    public LoanResponseDto bookReturn(LoanRequestDto loanRequestDto){
        // 이미 대출을 한 상태인지 확인
        Loan loan = returnRepository.findByBookIdAndMemberId(loanRequestDto.getBookId(), loanRequestDto.getMemberId());

        if(loan == null){
            throw new EntityNotFoundException("없는 대출 내역 입니다.");
        }

        if(loan.isReturnStatus()){
            throw new IllegalArgumentException("이미 해당 도서는 반납을 하였습니다.");
        }

        loan.setReturnStatus(true);
        loan.setReturnDate(LocalDate.now());

        return new LoanResponseDto(loan, "[SUCCESS] 도서 반납이 완료되었습니다.");
    }
}
