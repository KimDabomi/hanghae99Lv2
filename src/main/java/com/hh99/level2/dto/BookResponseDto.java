package com.hh99.level2.dto;

import com.hh99.level2.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class BookResponseDto {
    private Long id;
    private String title;
    private String author;
    private String lang;
    private String company;
    private LocalDateTime regDate;
    private boolean available;

    public BookResponseDto(Book book, boolean available) {
        this.id = book.getId();
        this.title = book.getTitle();
        this.author = book.getAuthor();
        this.lang = book.getLang();
        this.company = book.getCompany();
        this.regDate = book.getRegDate();
        this.available = available;
    }
}
