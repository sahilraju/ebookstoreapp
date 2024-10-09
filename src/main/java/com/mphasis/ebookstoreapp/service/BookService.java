package com.mphasis.ebookstoreapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mphasis.ebookstoreapp.entity.Book;
import com.mphasis.ebookstoreapp.repository.BookRepository;

@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;

	public Book addBook(Book book) {
		return bookRepository.save(book);
	}

	public List<Book> getAllBooks() {
		
		return bookRepository.findAll();
	}
	
	public Book updateBookById(Long id, Book bookDetails) {
        Book book = bookRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Book not found with id: " + id));
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setIsbn(bookDetails.getIsbn());
        book.setPages(bookDetails.getPages());
        book.setYear(bookDetails.getYear());
        book.setPublisher(bookDetails.getPublisher());
        return bookRepository.save(book);
    }

    public void deleteBookById(Long id) {
        bookRepository.deleteById(id);
    }

    public Optional<Book> getBookById(Long id) {
        return bookRepository.findById(id);
    }

    public List<Book> getBooksByTitle(String title) {
        return bookRepository.findByTitle(title);
    }

    public List<Book> getBooksByPublisher(String publisher) {
        return bookRepository.findByPublisher(publisher);
    }

    public List<Book> getBooksByYear(Integer year) {
        return bookRepository.findByBookYear(year);
    }

} 
