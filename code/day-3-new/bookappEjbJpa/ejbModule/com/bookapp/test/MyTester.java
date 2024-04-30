package com.bookapp.test;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

import com.bookapp.model.Book;
import com.bookapp.model.BookDao;

@Singleton
@Startup
public class MyTester {

	@EJB
	private BookDao bookDao;
	
	@PostConstruct
	public void test() {
		System.out.println("------------------------------");
		//printAll();
		Book book=bookDao.getById(1);
		System.out.println(book);
		
		System.out.println("------------------------------");
	}

	private void printAll() {
		List<Book> books=bookDao.getAll();
		for(Book book: books) {
			System.out.println(book);
		}
	}
	
}
