package com.promineotech.book.controller;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.book.entity.Book;
import com.promineotech.book.entity.BookAuthor;
import com.promineotech.book.service.BookService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j 
public class BasicBookController implements BookController {
  
  @Autowired
  private BookService bookService;
  
  //Get
  @Override
  public List<Book> fetchBook(String bookName) {
    log.info("bookName={}", bookName);
    
    return bookService.fetchBook(bookName);
  }
  
  //Post
  @Override
  public Optional<Book> createBook(String bookName, String locationName) {
    log.info("bookName={}, locationName={}", bookName, locationName);
    
    return bookService.createBook(bookName, locationName);
  }
  
  //Put
  @Override
  public Optional<Book> updateBookLocation(String bookName, String locationName, String newLocationName) {
    log.info("bookName={}, locationName={}, newLocationName={}", bookName, locationName, newLocationName);
        
    return bookService.updateBookLocation(bookName, locationName, newLocationName);
  }
  
  //Delete
  @Override
  public Optional<Book> deleteBook(String bookName) {
    log.info("bookName={}", bookName);
    
    return bookService.deleteBook(bookName);
   }
  
  //Get
  @Override
  public List<BookAuthor> fetchBooksByAuthor(String authorName) {
    log.info("authorName={}", authorName);
   return bookService.fetchBooksByAuthor(authorName);
}
  }
