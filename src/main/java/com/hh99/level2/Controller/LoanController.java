package com.hh99.level2.controller;

import com.hh99.level2.dto.LoanRequestDto;
import com.hh99.level2.dto.LoanResponseDto;
import com.hh99.level2.dto.MemberRequestDto;
import com.hh99.level2.dto.MemberResponseDto;
import com.hh99.level2.service.LoanService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class LoanController {

    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/loan")
    public LoanResponseDto createLoan(@RequestBody LoanRequestDto requestDto) {
        return loanService.createLoan(requestDto);
    }
}