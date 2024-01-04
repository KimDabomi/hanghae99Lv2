package com.hh99.level2.service;

import com.hh99.level2.dto.LoanRequestDto;
import com.hh99.level2.dto.LoanResponseDto;
import com.hh99.level2.entity.Loan;
import com.hh99.level2.message.ErrorMessage;
import com.hh99.level2.message.SuccessMessage;
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

    @Transactional
    public LoanResponseDto bookReturn(LoanRequestDto loanRequestDto){
        Loan loan = returnRepository.findByBookIdAndMemberId(loanRequestDto.getBookId(), loanRequestDto.getMemberId());

        if(loan == null){
            throw new EntityNotFoundException(ErrorMessage.EXIST_LOAN_ERROR_MESSAGE.getErrorMessage());
        }

        if(loan.isReturnStatus()){
            throw new IllegalArgumentException(ErrorMessage.ALREADY_RETURN_ERROR_MESSAGE.getErrorMessage());
        }

        loan.setLoanStatus(false);
        loan.setReturnStatus(true);
        loan.setReturnDate(LocalDate.now());

        return new LoanResponseDto(loan, SuccessMessage.RETURN_SUCCESS_MESSAGE.getSuccessMessage());
    }
}
