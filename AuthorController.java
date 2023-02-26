package com.promineotech.author.controller;

import java.util.List;


import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.promineotech.book.entity.Author;
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
@RequestMapping("/authors")

@OpenAPIDefinition(info = @Info(title = "Leslie's Library"), servers = {
    @Server(url = "http://localhost:8080", description = "Local server")})

public interface AuthorController {
  // @formatter:off
  @Operation(
      summary = "Returns author given authorname",
      description = "Returns author given authorname if author exists in table",
      responses = {
          @ApiResponse(
              responseCode = "200", 
              description = "Author is returned", 
              content = @Content(
                  mediaType = "application/json", 
                  schema = @Schema(implementation = Author.class))),
          @ApiResponse(
              responseCode = "400", 
              description = "The request parameters are invalid", 
              content = @Content(mediaType = "application/json")), 
          @ApiResponse(
              responseCode = "404", 
              description = "No authors were found with input criteria", 
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
              description = "Name of author")
          
      }
   )

@GetMapping
@ResponseStatus(code = HttpStatus.OK)
List<Author> fetchAuthor(
    @RequestParam(required = false)
    String authorName);
//@formatter:on
  
//@formatter:off
 @Operation(
     summary = "Returns author/s given a book name",
     description = "Returns author/s given a book name",
     responses = {
         @ApiResponse(
             responseCode = "200", 
             description = "Authors are returned", 
             content = @Content(
                 mediaType = "application/json", 
                 schema = @Schema(implementation = Author.class))),
         @ApiResponse(
             responseCode = "400", 
             description = "The request parameters are invalid", 
             content = @Content(mediaType = "application/json")), 
         @ApiResponse(
             responseCode = "404", 
             description = "No authors were found with input criteria", 
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
             description = "The book's name")
     }
 )
 
 @GetMapping(value = "/authors-by-bookname")
 @ResponseStatus(code = HttpStatus.OK)
     List<BookAuthor> fetchAuthorsByBook(
       @RequestParam(required = false) 
       String bookName);
  //@formatter:on
  
}

