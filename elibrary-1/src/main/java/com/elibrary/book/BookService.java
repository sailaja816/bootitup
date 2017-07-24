package com.elibrary.book;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class BookService {

	@Autowired
	private BookRepository bookRepository;
	
	public Book getBook(Integer id) {
		return bookRepository.findOne(id);
	}
	
	public List<Book> getAllBooksByAuthorId(Integer authorid){
		List<Book> books = new ArrayList<>();	
		bookRepository.findByAuthorId(authorid).forEach(books::add);
		return books;	
	}
	
	public List<Book> getAllBooks(){
		List<Book> books = new ArrayList<>();	
		bookRepository.findAll().forEach(books::add);
		return books;	
	}
	
	public Book addBook(Book book) {
		return bookRepository.save(book);
	}
	
	public Book updateBook(Book book) {
		return bookRepository.save(book);
	}
	
	public void deleteBook(Integer id) {
		bookRepository.delete(id);
	}
}
