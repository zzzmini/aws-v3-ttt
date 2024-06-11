package com.example.awsv3.dto;

import com.example.awsv3.entity.Book;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class BookSaveRequestDto {
    private String title;
    private String content;
    private String author;

    @Builder
    BookSaveRequestDto(String title, String content, String  author){
        this.title = title;
        this.content = content;
        this.author = author;
    }

    public Book toEntity(){
        return Book.builder()
                .title(title)
                .content(content)
                .author(author)
                .build();
    }
}
