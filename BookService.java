package com.promineotech.book.service;

import java.util.List;
import java.util.Optional;
import com.promineotech.book.entity.Book;
import com.promineotech.book.entity.BookAuthor;

public interface BookService {
  
  /**
   * 
   * @param bookName
   * @return
   */
  List<Book> fetchBook(String bookName);
  
  /**
   * 
   * @param bookName
   * @param locationName
   * @return
   */
  Optional<Book> createBook(String bookName, String locationName);
  
  /**
   * 
   * @param bookName
   * @param locationName
   * @param newLocationName
   * @return
   */
  Optional<Book> updateBookLocation(String bookName, String locationName, String newLocationName);
  
  /**
   * 
   * @param bookName
   * @return
   */
  Optional<Book> deleteBook(String bookName);
  
  
  /**
   * @param authorName
   * @return
   */
  List<BookAuthor> fetchBooksByAuthor(String authorName);

}
