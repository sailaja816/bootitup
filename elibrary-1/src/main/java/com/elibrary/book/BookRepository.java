package com.elibrary.book;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Integer>{
	
	public List<Book> findByAuthorId(Integer id);

}
