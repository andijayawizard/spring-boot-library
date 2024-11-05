package com.andijaya.library.services.book;

import com.andijaya.library.payloads.requests.BookRequest;
import com.andijaya.library.payloads.responses.Response;

public interface BookService {
    Response addBook(BookRequest request);
    Response getBooks();
    Response getBookById(String uuid);
    Response updateBookById(String uuid, BookRequest request);
    Response deleteBookById(String uuid);
}
