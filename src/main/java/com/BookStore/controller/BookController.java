package com.BookStore.controller;

import com.BookStore.model.Book;
import com.BookStore.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Access;

@RestController
public class BookController {
    @Autowired
    private BookService billService;

   @PostMapping("/store/{storeid}/Books")
    public ResponseEntity<?> createBook(@RequestBody Book book, @PathVariable Long bookId)

    /*@GetMapping()
    *public Respon

     */
}
