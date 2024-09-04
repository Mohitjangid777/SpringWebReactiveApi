package com.Spring_reactive_Api.Service.Impl;

import com.Spring_reactive_Api.Entity.Book;
import com.Spring_reactive_Api.Repositories.BookRepository;
import com.Spring_reactive_Api.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
@Service
public class BookServiceImpl implements BookService {

   @Autowired
   private BookRepository repository;

    @Override
    public Mono<Book> create(Book book) {
        Mono<Book> createdBook = repository.save(book);
        return createdBook;
    }

    @Override
    public Flux<Book> getAll() {
        return repository.findAll();
    }

    @Override
    public Mono<Book> getBookId(int bookId)
    {
        Mono<Book> byId = repository.findById(bookId);
        return byId;
    }

    @Override
    public Mono<Book> updateBook(Book book, int bookId) {
        Mono<Book> bookMono = repository.findById(bookId);
       return bookMono.flatMap(book1 ->{
            book1.setName(book.getName());
            book1.setPublisher(book.getPublisher());
            book1.setAuthor(book.getAuthor());
            book1.setDescription(book.getDescription());
            return repository.save(book1);
        });

    }

    @Override
    public Mono<Void> delete(int bookId) {
        return repository
                .findById(bookId)
                .flatMap(book -> repository.delete( book));

    }

    @Override
    public Flux<Book> search(String query) {
        return repository.searchByTitle("%"+query+"%");
    }
}
