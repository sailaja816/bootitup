package com.elibrary.book;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.elibrary.author.Author;
import com.fasterxml.jackson.annotation.JsonBackReference;
@Entity
@Table(name="book")
public class Book implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
    private Integer id; 
	@ManyToOne
	@JsonBackReference
    private Author author;
	@Column(name="name")
    private String bookName;
	public Book()
    {
        super();
    }

    public Book(Integer bookId, String bookName, Author author)
    {
        super();
        this.id = bookId;
        this.bookName = bookName;
        this.author = author;
    }

	public Integer getBookId() {
		return id;
	}

	public void setBookId(Integer bookId) {
		this.id = bookId;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
    
}
