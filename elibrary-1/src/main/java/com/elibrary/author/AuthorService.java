package com.elibrary.author;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elibrary.book.Book;
import com.elibrary.book.BookRepository;

@Service
public class AuthorService {

	@Autowired
	private AuthorRepository authorRepository;
	
	public Author getAuthor(Integer id) {
		return authorRepository.findOne(id);
	}
	
	public List<Author> getAllAuthors(){
		List<Author> authors = new ArrayList<>();	
		authorRepository.findAll().forEach(authors::add);
		return authors;	
	}
	
	public Author addAuthor(Author book) {
		return authorRepository.save(book);
	}
	
	public Author updateAuthor(Author book) {
		return authorRepository.save(book);
	}
	
	public void deleteAuthor(Integer id) {
		authorRepository.delete(id);
	}
}
