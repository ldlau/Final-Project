package com.promineotech.book.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Author {
  private Integer authorId;
  private String authorName;
  
}