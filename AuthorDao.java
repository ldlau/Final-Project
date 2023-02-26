package com.promineotech.author.dao;

import java.util.List;
import com.promineotech.book.entity.Author;
import com.promineotech.book.entity.BookAuthor;


public interface AuthorDao {
  /**
   * 
   * @param authorName
   * @return
   */
  List<Author> fetchAuthor(String authorName);

  /**
   * 
   * @param bookName
   * @return
   */
  List<BookAuthor> fetchAuthorsByBook(String bookName);
  
 
}