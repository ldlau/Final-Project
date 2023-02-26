package com.promineotech.author.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.promineotech.author.service.AuthorService;
import com.promineotech.book.entity.Author;
import com.promineotech.book.entity.BookAuthor;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j

public class BasicAuthorController implements AuthorController {
  @Autowired
  private AuthorService authorService;
  
  @Override
  public List<Author> fetchAuthor(String authorName) {
    log.info("authorName={}", authorName);
    return authorService.fetchAuthor(authorName);
  }

  @Override
  public List<BookAuthor> fetchAuthorsByBook(String bookName) {
    log.info("bookName={}", bookName);
    return authorService.fetchAuthorsByBook(bookName);
  }
}