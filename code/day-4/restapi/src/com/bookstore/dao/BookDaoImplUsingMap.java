package com.bookstore.dao;

import java.util.*;

import com.bookstore.exceptions.BookNotFoundException;

public class BookDaoImplUsingMap implements BookDao{
	private static Map<Integer, Book> books=new HashMap<Integer, Book>();
	private static int counter;
	static {
		books.put(1, new Book(1, "ABC123", "head first", "katthy", 500.00));
		books.put(2, new Book(2, "ABU123", "thinking in java", "amit", 400.00));
		counter=2;
	}
	
	@Override
	public List<Book> getAll() {	
		return new ArrayList<Book>(books.values());
	}

	@Override
	public Book getBookById(int bookId) {
		Book book= books.get(bookId);
		if(book==null)
			throw new BookNotFoundException("book with id "+ bookId +" is not found");
		
		return book;
	}

	@Override
	public Book addBook(Book book) {
		book.setId(++counter);
		books.put(book.getId(), book);
		return book;
	}

	@Override
	public Book updateBook(int bookId, Book book) {
		Book bookToUpdate= getBookById(bookId);
		bookToUpdate.setPrice(book.getPrice());
		books.put(bookId, bookToUpdate);
		
		return bookToUpdate;
	}

	@Override
	public Book removeBook(int bookId) {
		Book bookToRemove=getBookById(bookId);
		books.remove(bookId);
		return bookToRemove;
	}

}
