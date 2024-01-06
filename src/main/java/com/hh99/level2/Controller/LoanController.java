package com.hh99.level2.controller;

import com.hh99.level2.dto.*;
import com.hh99.level2.service.LoanService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class LoanController {
    private final LoanService loanService;

    public LoanController(LoanService loanService) {
        this.loanService = loanService;
    }

    @PostMapping("/loans")
    public LoanResponseDto createLoan(@RequestBody LoanRequestDto requestDto) {
        return loanService.createLoan(requestDto);
    }

    @GetMapping("/members/loans/{memberId}")
    public List<LoanHistoryDto> getLoanHistoryForMember(@PathVariable Long memberId) {
        return loanService.getLoanHistoryForMember(memberId);
    }
}