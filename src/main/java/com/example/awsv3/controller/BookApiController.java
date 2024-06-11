package com.example.awsv3.controller;

import com.example.awsv3.dto.BookResponseDto;
import com.example.awsv3.dto.BookSaveRequestDto;
import com.example.awsv3.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
@RequiredArgsConstructor
@RestController
public class BookApiController {
    private final BookService bookService;

    @GetMapping("/")
    public String home(){
        return "<h1>aws-v3</h1>";
    }

    @PostMapping("/api/book")
    public ResponseEntity<?> bookSave(@RequestBody BookSaveRequestDto bookSaveRequestDto){
        BookResponseDto responseDto = bookService.bookSave(bookSaveRequestDto);
        return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
    }

    @GetMapping("/api/book")
    public ResponseEntity<?> bookList(){
        List<BookResponseDto> responseDtoList = bookService.bookList();
        return new ResponseEntity<>(responseDtoList, HttpStatus.OK);
    }
}
