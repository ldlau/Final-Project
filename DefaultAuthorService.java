package com.promineotech.author.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.author.dao.AuthorDao;
import com.promineotech.book.entity.Author;
import com.promineotech.book.entity.BookAuthor;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DefaultAuthorService implements AuthorService {
  @Autowired
  private AuthorDao authorDao;
  
  @Transactional
  @Override
  public List<Author> fetchAuthor(String authorName) {
    log.info("authorName={}", authorName);
    return authorDao.fetchAuthor(authorName);
  }

  @Override
  public List<BookAuthor> fetchAuthorsByBook(String bookName) {
    log.info("bookName={}", bookName);
    return authorDao.fetchAuthorsByBook(bookName);
  }
}