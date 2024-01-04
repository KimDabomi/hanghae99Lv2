package com.hh99.level2.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class BookRequestDto {
    private Long id;
    private String title;
    private String author;
    private String lang;
    private String company;
    private LocalDateTime regDate;
}
