package com.hh99.level2.service;

import com.hh99.level2.dto.BookRequestDto;
import com.hh99.level2.dto.BookResponseDto;
import com.hh99.level2.entity.Book;
import com.hh99.level2.repository.BookRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    // 도서 등록 기능
    public BookResponseDto save(BookRequestDto bookRequestDto){
        return new BookResponseDto(bookRepository.save(new Book(bookRequestDto)));
    }

    // 도서 전체 조회
    public List<BookResponseDto> findAll(){
        return bookRepository.findAll().stream()
                .map(BookResponseDto::new)
                .collect(Collectors.toList());
    }

    // 도서 상세 조회
    public BookResponseDto find(Long bookId){
        Book book = bookRepository.findById(bookId)
                .orElseThrow(() -> new EntityNotFoundException("없는 도서 입니다."));

        BookResponseDto bookResponseDto = new BookResponseDto(book);
        bookResponseDto.setId(book.getId());

        return bookResponseDto;
    }
}
