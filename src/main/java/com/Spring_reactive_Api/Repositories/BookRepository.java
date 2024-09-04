package com.Spring_reactive_Api.Repositories;

import com.Spring_reactive_Api.Entity.Book;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.relational.core.sql.From;
import org.springframework.data.relational.core.sql.Select;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;

public interface BookRepository extends ReactiveCrudRepository<Book,Integer> {
    @Query("select * from book_details where name LIKE :query")
    Flux<Book> searchByTitle(String query);
}
