package com.andijaya.library.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.andijaya.library.payloads.requests.BookRequest;
import com.andijaya.library.payloads.responses.Response;
import com.andijaya.library.services.book.BookService;

public class BookController {
      @Autowired
  private BookService bookService;

  @PostMapping
  public ResponseEntity<?> addBook(@RequestBody BookRequest bookRequest) {
    try {
      Response response = bookService.addBook(bookRequest);
      return ResponseEntity.status(response.getStatus()).body(response);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(e.getMessage());
    }
  }

  @GetMapping
  public ResponseEntity<?> getBooks() {
    try {
      Response response = bookService.getBooks();
      return ResponseEntity.status(response.getStatus()).body(response);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(e.getMessage());
    }
  }

  @GetMapping("/{uuid}")
  public ResponseEntity<?> getBookById(@PathVariable("uuid") String id) {
    try {
      Response response = bookService.getBookById(id);
      return ResponseEntity.status(response.getStatus()).body(response);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(e.getMessage());
    }
  }

  @PutMapping("/{uuid}")
  public ResponseEntity<?> updateBook(@PathVariable("uuid") String id, @RequestBody BookRequest bookRequest) {
    try {
      Response response = bookService.updateBookById(id, bookRequest);
      return ResponseEntity.status(response.getStatus()).body(response);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(e.getMessage());
    }
  }

  @DeleteMapping("/{uuid}")
  public ResponseEntity<?> deleteBook(@PathVariable("uuid") String id) {
    try {
      Response response = bookService.deleteBookById(id);
      return ResponseEntity.status(response.getStatus()).body(response);
    } catch (Exception e) {
      return ResponseEntity.internalServerError().body(e.getMessage());
    }
  }

}
