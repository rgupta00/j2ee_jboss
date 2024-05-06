package com.bookstore.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.dao.Book;
import com.bookstore.dao.BookDao;

@RestController
public class BookRestController {
	
	@Autowired
	private BookDao bookDao;
	
	//get all the books
	@GetMapping(path="books")
	public List<Book> getAll(){
		return bookDao.getAll();
	}
	//get a particular book
	
	@GetMapping(path="books/{id}")
	public Book getById(@PathVariable(name="id")  int id){
		return bookDao.getBookById(id);
	}

}
