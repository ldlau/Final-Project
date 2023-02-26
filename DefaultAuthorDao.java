 package com.promineotech.author.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;
import com.promineotech.book.entity.Author;
import com.promineotech.book.entity.BookAuthor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class DefaultAuthorDao implements AuthorDao {
  
  @Autowired
  private NamedParameterJdbcTemplate jdbcTemplate;
  
  //GET 
  @Override
  public List<Author> fetchAuthor(String authorName) {
    log.info("DAO: authorName={}", authorName);
    
    //@formatter:off
    String sql = ""
        + "SELECT * "
        + "FROM author "
        + "WHERE author_name = :author_name";
    //@formatter:on
    
    Map<String, Object> params = new HashMap<>();
    params.put("author_name", authorName);
    
    return jdbcTemplate.query(sql, params, new RowMapper<>() {
      @Override
      public Author mapRow(ResultSet rs, int rowNum) throws SQLException {
        //@formatter:off
        return Author.builder()
            .authorName(rs.getString("author_name"))
            .authorId(rs.getInt("author_id"))
            .build();
        //@formatter:on
      }
    });
   }
  @Override
  public List<BookAuthor> fetchAuthorsByBook(String bookName) {
    //@formatter:off
    String sql = "SELECT b.book_name, a.author_name "
        + "FROM book b "
        + "INNER JOIN book_author ba on b.book_id = ba.book_id "
        + "INNER JOIN author a on ba.author_id = a.author_id "
        + "WHERE book_name = :book_name";
    //@formatter:on
    Map<String, Object> params = new HashMap<>();
    params.put("book_name", bookName);
    
    return jdbcTemplate.query(sql,  params, new RowMapper<>() {
      
      @Override
      public BookAuthor mapRow(ResultSet rs, int rowNum) throws SQLException {
        //@formatter:off
        return BookAuthor.builder()
            .bookName(rs.getString("book_name"))
            .authorName(rs.getString("author_name"))
            .build();
        //@formatter:on
        }
    });
 }
 }