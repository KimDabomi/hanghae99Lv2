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
    public BookResponseDto createBook(@RequestBody BookRequestDto bookRequestDto){
        return bookService.createBook(bookRequestDto);
    }

    @GetMapping("/book")
    public List<BookResponseDto> getBooks(){
        return bookService.getBooks();
    }

    @GetMapping("/book/{bookId}")
    public BookResponseDto getBook(@PathVariable Long bookId){
        return bookService.getBook(bookId);
    }
}
