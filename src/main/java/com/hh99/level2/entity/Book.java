package com.hh99.level2.entity;

import com.hh99.level2.dto.BookRequestDto;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Table(name="books")
@NoArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    @Column
    private String author;

    @Column
    private String lang;

    @Column
    private String company;

    @Column(name="reg_date")
    private LocalDateTime regDate;

    public Book(BookRequestDto bookRequestDto){
        this.title = bookRequestDto.getTitle();
        this.author = bookRequestDto.getAuthor();
        this.lang = bookRequestDto.getLang();
        this.company = bookRequestDto.getCompany();
        this.regDate = LocalDateTime.now();
    }
}