package com.mphasis.ebookstoreapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mphasis.ebookstoreapp.entity.Book;
import com.mphasis.ebookstoreapp.service.BookService;

@RestController
@RequestMapping("/book")
public class BookController {
	
	@Autowired
    private BookService bookService;
 
    @PostMapping
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book savedBook = bookService.addBook(book);
        return new ResponseEntity<>(savedBook, HttpStatus.CREATED);
    }
    
    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        List<Book> books = bookService.getAllBooks();
        return new ResponseEntity<>(books, HttpStatus.OK);
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBookById(@PathVariable Long id, @RequestBody Book bookDetails) {
        Book updatedBook = bookService.updateBookById(id, bookDetails);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookById(@PathVariable Long id) {
        bookService.deleteBookById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        return bookService.getBookById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/title/{book_title}")
    public List<Book> getBooksByTitle(@PathVariable("book_title") String title) {
        return bookService.getBooksByTitle(title);
    }

    @GetMapping("/publisher/{book_publisher}")
    public List<Book> getBooksByPublisher(@PathVariable("book_publisher") String publisher) {
        return bookService.getBooksByPublisher(publisher);
    }

    @GetMapping("year/{year}")
    public List<Book> getBooksByYear(@PathVariable Integer year) {
        if (year != null) { 
            return bookService.getBooksByYear(year);
        }
        return bookService.getAllBooks(); 
    }

}
   