package com.Spring_reactive_Api.Controller;

import com.Spring_reactive_Api.Entity.Book;
import com.Spring_reactive_Api.Service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;

@RestController
@RequestMapping("/books")

public class BookController {
    @Autowired
    private BookService bookService;

    @PostMapping
    public Mono<Book> create(@RequestBody Book book){
       return bookService.create(book);
    }
     @GetMapping
    public Flux<Book> gertALL(){
       return bookService.getAll().delayElements(Duration.ofSeconds(2));
    }

    @GetMapping("/{bookId}")
    public Mono<Book> getById(@PathVariable int bookId){
      return  bookService.getBookId(bookId);
    }

    @PutMapping("/{BookId}")
    public Mono<Book> update(@RequestBody Book book,@PathVariable int BookId){
       return bookService.updateBook(book,BookId);
    }

    @DeleteMapping("/{bookId}")
    public Mono<Void> delete(@PathVariable int bookId){
       return bookService.delete(bookId);
    }

    @GetMapping("/search")
    public Flux<Book> SearchBook(@RequestParam("query") String query){
        return bookService.search(query);
    }
}
