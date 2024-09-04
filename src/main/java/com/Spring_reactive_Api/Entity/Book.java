package com.Spring_reactive_Api.Entity;

import jakarta.annotation.Generated;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Book_details")
public class Book {

    @Id
    private int bookId;
    private String name;
    private String description;
    private String publisher;
    private String author;
}
