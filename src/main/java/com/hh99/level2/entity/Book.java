package com.hh99.level2.entity;

import com.hh99.level2.dto.BookRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name="books")
@Entity
@NoArgsConstructor
@Getter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private String author;

    @Column(nullable = false)
    private String lang;

    @Column(nullable = false)
    private String company;

    @Column(name="reg_date", nullable = false)
    private LocalDateTime regDate;

    public Book(BookRequestDto bookRequestDto){
        this.title = bookRequestDto.getTitle();
        this.author = bookRequestDto.getAuthor();
        this.lang = bookRequestDto.getLang();
        this.company = bookRequestDto.getCompany();
        this.regDate = LocalDateTime.now();
    }
}