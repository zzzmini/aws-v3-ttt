package com.example.awsv3.dto;

import com.example.awsv3.entity.Book;
import lombok.Builder;
import lombok.Getter;

@Getter
public class BookResponseDto {
    private Long id;
    private String title;
    private String content;
    private String author;

    @Builder
    public BookResponseDto(Long id, String title, String content, String author){
        this.id = id;
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public BookResponseDto(Book book){
        this.id = book.getId();
        this.title = book.getTitle();
        this.content = book.getContent();
        this.author = book.getAuthor();
    }
}
