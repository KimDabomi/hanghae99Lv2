package com.hh99.level2.controller;

import com.hh99.level2.dto.BookRequestDto;
import com.hh99.level2.dto.LoanRequestDto;
import com.hh99.level2.dto.LoanResponseDto;
import com.hh99.level2.dto.MemberRequestDto;
import com.hh99.level2.entity.Book;
import com.hh99.level2.entity.Member;
import com.hh99.level2.service.ReturnService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ReturnController {
    private final ReturnService returnService;

    @PutMapping("/return")
    public LoanResponseDto bookReturn(@RequestBody LoanRequestDto loanRequestDto){
        returnService.bookReturn(loanRequestDto);
    }
}