package com.promineotech.book.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder

public class BookAuthor {
  private Integer bookId;
  private Integer authorId;
  private String bookName;
  private String authorName;
}