package com.promineotech.book.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
  
 
public class Book {
  private Integer bookId;
  private String bookName;
  private String locationName;
}