package com.promineotech.book.controller;


import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.book.entity.Book;
import com.promineotech.book.entity.BookAuthor;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

@Validated
@RequestMapping("/books")
@OpenAPIDefinition(info = @Info(title = "Leslie's Library"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server")})

public interface BookController {
  // @formatter:off
  @Operation(
      summary = "Returns book given bookname",
      description = "Returns book given bookname if book exists in table",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "Book is returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Book.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid", 
              content = @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode = "404", 
              description = "No books were found with input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An uplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      
      },
      parameters = {
          @Parameter(
              name = "bookName",
              allowEmptyValue = false,
              required = false,
              description = "The book name")
      }
  )
  
  @GetMapping(value = "/books-by-bookname")
  @ResponseStatus(code = HttpStatus.OK)
      List<Book> fetchBook(
        @RequestParam(required = false) 
        String bookName);
   //@formatter:on
      
  //@formatter:off
  @Operation(
      summary = "Creates a book",
      description = "Creates a book",
      responses = {
          @ApiResponse(
              responseCode = "201", 
              description = "Book is created", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Book.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid", 
              content = @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode = "404", 
              description = "Unable to create a book with input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An uplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      },
      
      parameters = {
          @Parameter (
              name = "bookName",
              allowEmptyValue = false,
              required = true,
              description = "The name of the book"),
          @Parameter (
              name = "locationName",
              allowEmptyValue = false,
              required = true,
              description = "Where the book is located")
      }
    )
          
  @PostMapping
  @ResponseStatus(code = HttpStatus.CREATED)
    Optional<Book> createBook(
      @RequestParam(required = true)
       String bookName,
      @RequestParam(required = true)
       String bookLocation);
  //@formatter:on
  
  //@formatter:off
  @Operation(
      summary = "Updates a book's location",
      description = "Updates a book's location",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "Book location is updated", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Book.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid", 
              content = @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode = "404", 
              description = "Book location not updated with input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An uplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      
      },
      parameters = {
          @Parameter(
              name = "bookName", 
              allowEmptyValue = false, 
              required = true, 
              description = "The book name"),
          @Parameter(
              name = "locationName",
              allowEmptyValue = false,
              required = false,
              description = "The current book location"),
          @Parameter(
              name = "newLocationName",
              allowEmptyValue = false,
              required = true,
              description = "The new location of the book")
      }
  )
  
  @PutMapping
  @ResponseStatus(code = HttpStatus.OK)
  Optional<Book> updateBookLocation(
      @RequestParam(required = true) 
      String bookName,
      @RequestParam(required = false)
      String locationName,
      @RequestParam(required = true)
      String newLocationName);
  //@formatter:on
  
  //@formatter:off
  @Operation(
      summary = "Deletes a book",
      description = "Deletes a book",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "Book is deleted", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Book.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid", 
              content = @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode = "404", 
              description = "Book is not deleted due to input criteria", 
              content = @Content(mediaType = "application/json")),
          @ApiResponse(
              responseCode = "500", 
              description = "An uplanned error occurred", 
              content = @Content(mediaType = "application/json"))
      
      },
      parameters = {
          @Parameter(
              name = "bookName", 
              allowEmptyValue = false, 
              required = true, 
              description = "The book name"),
      }
  )
  @DeleteMapping
  @ResponseStatus(code = HttpStatus.OK)
  Optional<Book> deleteBook(
      @RequestParam(required = true) 
      String bookName);
  
//@formatter:off
 @Operation(
     summary = "Returns book/s given author name",
     description = "Returns book/s given author's name if book exists in table",
     responses = {
         @ApiResponse(
             responseCode = "200", 
             description = "Book is returned", 
             content = @Content(
                 mediaType = "application/json", 
                 schema = @Schema(implementation = Book.class))),
         @ApiResponse(
             responseCode = "400", 
             description = "The request parameters are invalid", 
             content = @Content(mediaType = "application/json")), 
         @ApiResponse(
             responseCode = "404", 
             description = "No books were found with input criteria", 
             content = @Content(mediaType = "application/json")),
         @ApiResponse(
             responseCode = "500", 
             description = "An uplanned error occurred", 
             content = @Content(mediaType = "application/json"))
     
     },
     parameters = {
         @Parameter(
             name = "authorName",
             allowEmptyValue = false,
             required = false,
             description = "The author's name")
     }
 )
 
 @GetMapping(value = "/books-by-authorname")
 @ResponseStatus(code = HttpStatus.OK)
     List<BookAuthor> fetchBooksByAuthor(
       @RequestParam(required = false) 
       String authorName);
  //@formatter:on
  
}
