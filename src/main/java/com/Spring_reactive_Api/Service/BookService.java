package com.Spring_reactive_Api.Service;

import com.Spring_reactive_Api.Entity.Book;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;


public interface BookService {

    public Mono<Book> create(Book book);

    public Flux<Book> getAll();

    public Mono<Book> getBookId(int bookId);

    public Mono<Book> updateBook(Book book,int bookId);

    public Mono<Void> delete(int bookId);

    public Flux<Book> search(String query);

}
