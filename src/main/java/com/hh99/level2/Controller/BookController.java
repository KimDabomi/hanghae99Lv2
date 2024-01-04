package com.hh99.level2.controller;

import com.hh99.level2.dto.BookRequestDto;
import com.hh99.level2.dto.BookResponseDto;
import com.hh99.level2.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class BookController {

    private final BookService bookService;

    @PostMapping("/book")
    public BookResponseDto save(@RequestBody BookRequestDto bookRequestDto){
        return bookService.save(bookRequestDto);
    }

    @GetMapping("/books")
    public List<BookResponseDto> findAll(){
        return bookService.findAll();
    }

    @GetMapping("/books/{bookId}")
    public BookResponseDto find(@PathVariable Long bookId){
        return bookService.find(bookId);
    }
}
