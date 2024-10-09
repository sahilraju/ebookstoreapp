package com.mphasis.ebookstoreapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mphasis.ebookstoreapp.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

	List<Book> findByTitle(String title);

	List<Book> findByPublisher(String publisher);

	List<Book> findByBookYear(Integer year);

}
