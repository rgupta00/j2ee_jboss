package com.bookapp.model;

import java.util.List;

import javax.ejb.Remote;

@Remote
public interface BookDao {
	public List<Book> getAll();
	public Book addBook(Book book);
	public Book getById(int id);
	public Book updateBook(int id, Book book);
	public Book deleteBook(int id);
}
