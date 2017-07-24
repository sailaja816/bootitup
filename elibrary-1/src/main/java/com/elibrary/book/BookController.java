package com.elibrary.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("book")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping("getbook")
	public Book getArticleById(@RequestParam("id") String id) {
		Book book = bookService.getBook(Integer.parseInt(id));
		return book;
	}
	
	@GetMapping("author")
	public List<Book> getBookByAuthorId(@RequestParam("id") String id) {
		return bookService.getAllBooksByAuthorId(Integer.parseInt(id));
	}
	
	@GetMapping("getall")
	public List<Book> getAllBooks() {
		return bookService.getAllBooks();
		}
	
	@PostMapping("addbook")
	public Book createBook(@RequestBody Book book) {
		return bookService.addBook(book);
	}
	
	@PutMapping("updatebook")
	public Book updateArticle(@RequestBody Book book) {
		return bookService.updateBook(book);
	}
	@DeleteMapping("deletebook")
	public String deleteBook(@RequestParam("id") String id) {
		bookService.deleteBook(Integer.parseInt(id));
		return "Book Deleted from records";
	}

	
}
