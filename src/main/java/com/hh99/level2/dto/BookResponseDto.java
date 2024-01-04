package com.hh99.level2.dto;

import com.hh99.level2.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class BookResponseDto {
    private String title;
    private String author;
    private String lang;
    private String company;
    private LocalDateTime regDate;

    public BookResponseDto(Book book) {
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.lang = book.getLang();
        this.company = book.getCompany();
        this.regDate = book.getRegDate();
    }
}
