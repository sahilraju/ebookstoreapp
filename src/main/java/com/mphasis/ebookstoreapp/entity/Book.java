package com.mphasis.ebookstoreapp.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increment strategy
    private Long id;

    private String title;

    private String author;

    private String isbn;

    private Integer pages;

    private Integer bookYear; 

    private String publisher;

    // Constructors
    public Book() {
    }

    public Book(String title, String author, String isbn, Integer pages, Integer bookYear, String publisher) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.pages = pages;
        this.bookYear = bookYear;
        this.publisher = publisher;
    }

    // Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    } 

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public Integer getYear() {
        return bookYear;
    }

    public void setYear(Integer year) {
        this.bookYear = year;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }
}

