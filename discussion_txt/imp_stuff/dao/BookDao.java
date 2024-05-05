package com.bookapp.dao;

import java.util.List;

public interface BookDao {
	public List<Book> getAll();
	public Book getBookById(int bookId);
	public Book addBook(Book book);
	public Book updateBook(int bookId, Book book);
	public Book removeBook(int bookId);
	
}