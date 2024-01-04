package com.hh99.level2.service;

import com.hh99.level2.dto.BookRequestDto;
import com.hh99.level2.dto.BookResponseDto;
import com.hh99.level2.entity.Book;
import com.hh99.level2.repository.BookRepository;
import com.hh99.level2.repository.LoanRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final LoanRepository loanRepository;

    public BookResponseDto createBook(BookRequestDto bookRequestDto){
        Book savedBook = bookRepository.save(new Book(bookRequestDto));
        boolean available = loanRepository.findByBookAndReturnStatusFalse(savedBook).isEmpty();

        return new BookResponseDto(savedBook, available);
    }

    public List<BookResponseDto> getBooks(){
        return bookRepository.findAll().stream()
                .map(book -> {
                    boolean available = loanRepository.findByBookAndReturnStatusFalse(book).isEmpty();
                    return new BookResponseDto(book, available);
                })
                .collect(Collectors.toList());
    }

    public BookResponseDto getBook(Long bookId){
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("없는 도서 입니다."));

        boolean available = loanRepository.findByBookAndReturnStatusFalse(book).isEmpty();

        return new BookResponseDto(book, available);
    }
}
