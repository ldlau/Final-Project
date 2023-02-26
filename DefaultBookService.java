package com.promineotech.book.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.book.dao.BookDao;
import com.promineotech.book.entity.Book;
import com.promineotech.book.entity.BookAuthor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j

public class DefaultBookService implements BookService {
  @Autowired
  private BookDao bookDao;
  
  @Transactional 
  @Override 
  
  public List<Book> fetchBook(String bookName) {
         log.info("bookName={}", bookName);
    return bookDao.fetchBook( bookName);
  }

  @Override
  public Optional<Book> createBook(String bookName, String locationName) {
         log.info("bookName={}, locationName={}", bookName, locationName);
    return bookDao.createBook(bookName, locationName);
  }

  @Override
  public Optional<Book> updateBookLocation(String bookName, String locationName,
      String newLocationName) {
         log.info("bookName={}, locationName={}, newLocationName{}", bookName, locationName, newLocationName);
    return bookDao.updateBookLocation(bookName, newLocationName, locationName);
  }

  @Override
  public Optional<Book> deleteBook(String bookName) {
         log.info("bookName={}", bookName);
    return bookDao.deleteBook(bookName);
  }

  @Override
  public List<BookAuthor> fetchBooksByAuthor(String authorName) {
         log.info("authorName={}", authorName);
    return bookDao.fetchBooksByAuthor(authorName);
  }
}