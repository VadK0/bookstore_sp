package com.example.bookstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long catid;
	private String name;
	
	@JsonBackReference
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	private List<Book> books;
	
	public Category( ) {}

	public Category(String name) {
		super();
		this.name = name;
	}

	public Long getCatid() {
		return catid;
	}

	public void setCatid(Long catid) {
		this.catid = catid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Book> getBooks() {
		return books;
	}

	public void setBooks(List<Book> books) {
		this.books = books;
	}

	@Override
	public String toString() {
		return "Category [catid=" + catid + ", name=" + name + "]";
	}
	
	
}
