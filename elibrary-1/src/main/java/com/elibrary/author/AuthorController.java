package com.elibrary.author;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("author")
public class AuthorController {
	@Autowired
	private AuthorService AuthorService;
	
	@GetMapping("getAuthor")
	public Author getAuthorById(@RequestParam("id") String id) {
		Author author = AuthorService.getAuthor(Integer.parseInt(id));
		return author;
	}
	
	@GetMapping("getall")
	public List<Author> getAllAuthors() {
		return AuthorService.getAllAuthors();
		}
	
	@PostMapping("addAuthor")
	public Author createAuthor(@RequestBody Author author) {
		return AuthorService.addAuthor(author);
	}
	
	@PutMapping("updateAuthor")
	public Author updateAuthor(@RequestBody Author author) {
		return AuthorService.updateAuthor(author);
	}
	@DeleteMapping("deleteAuthor")
	public String deleteAuthor(@RequestParam("id") String id) {
		AuthorService.deleteAuthor(Integer.parseInt(id));
		return "Author Deleted from records";
	}
}
