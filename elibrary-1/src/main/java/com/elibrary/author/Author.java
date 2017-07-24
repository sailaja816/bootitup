package com.elibrary.author;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.elibrary.book.Book;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name="author")
public class Author implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="id")
    private Integer id; 
	@Column(name="first_name")
    private String firstName;
	@Column(name="last_name")	
	private String lastName;
	@Column(name="city")	
	private String city;
	@OneToMany(targetEntity=Book.class,mappedBy="author",fetch=FetchType.EAGER,cascade = CascadeType.ALL)
	@JsonManagedReference
	private Set<Book> books;
	public Author()
    {
        super();
    }

    public Author(int authorId, String firstName, String lastName, String city, Set<Book> books)
    {
        super();
        this.id = authorId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.city = city;
        this.books = books;
    }
	public Integer getId() {
		return id;
	}
	public void setId(Integer authorId) {
		this.id = authorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public Set<Book> getBooks() {
		return books;
	}
	public void setBooks(Set<Book> books) {
		this.books = books;
	}
	
}
