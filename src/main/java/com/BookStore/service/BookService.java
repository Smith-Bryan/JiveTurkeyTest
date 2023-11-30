package com.BookStore.service;

import com.BookStore.dto.BookNotFoundException;
import com.BookStore.model.Book;
import com.BookStore.model.Category;
import com.BookStore.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {


    @Autowired
    BookRepository bookRepository;
    private final Logger logger = LoggerFactory.getLogger(BookService.class);
    public Book createBook(Book book, Category categories){
        logger.info("Book Created");
        return bookRepository.save(book);
    }

    public Optional<Book> getById(Long bookId){
        logger.info("Book with id " + bookId + " Retrieved");
        return bookRepository.findById(bookId);
    }

    public Iterable<Book> allBooks(){
        logger.info("All books front and center! ");
        return bookRepository.findAll();
    }

    public Book editBook(Book book, Category category, Long bookId){
        logger.info("Book edited");
        Optional<Book> existingBookOptional = bookRepository.findById(bookId);
        if (!existingBookOptional.isEmpty()){
            throw new BookNotFoundException("Book with an id of " + bookId + "cannot be found");
        }
        Book existingBook = existingBookOptional.get();
        existingBook.setName(book.getName());
        existingBook.setSku(book.getSku());
        existingBook.setAuthor(book.getAuthor());
        existingBook.setGenre(book.getGenre());
        existingBook.setType(category.getBookType());

        return bookRepository.save(existingBook);

    }

    public void noboodyReads(Long bookId){
        logger.info("Book Removed Successfully");
//        logger.error("Book Removed already");
        bookRepository.deleteById(bookId);
    }

}
