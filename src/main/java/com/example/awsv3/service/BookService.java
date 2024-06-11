package com.example.awsv3.service;

import com.example.awsv3.dto.BookResponseDto;
import com.example.awsv3.dto.BookSaveRequestDto;
import com.example.awsv3.entity.Book;
import com.example.awsv3.repository.BookRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    @Transactional
    public BookResponseDto bookSave(BookSaveRequestDto bookSaveRequestDto) {
        Book book = bookRepository.save(bookSaveRequestDto.toEntity());
        return new BookResponseDto(book);
    }

    @Transactional
    public List<BookResponseDto> bookList(){
        List<Book> books = bookRepository.findAll();
        System.out.println("사이즈 : " + books.size());
        return books.stream()
                .map(book -> new BookResponseDto(book))
                .collect(Collectors.toList());
    }
}
