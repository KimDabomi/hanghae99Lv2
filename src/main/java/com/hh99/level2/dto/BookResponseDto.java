package com.hh99.level2.dto;

import com.hh99.level2.entity.Book;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@AllArgsConstructor
@Getter
public class BookResponseDto {
    @Setter
    private Long id;
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
