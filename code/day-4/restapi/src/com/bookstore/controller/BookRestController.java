package com.bookstore.controller;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.bookstore.dao.Book;
import com.bookstore.dao.BookDao;
import com.bookstore.dao.BookDaoImplUsingMap;

@Path("/bookapp")
public class BookRestController {

	private BookDao bookDao=new BookDaoImplUsingMap();
	
	//get all books
	@GET
	@Path("/books")
	@Produces(MediaType.APPLICATION_JSON)
	public List<Book> getAll(){
		return bookDao.getAll();
	}
	
	//get book by id
	@GET
	@Path("/books/{id}")
	@Produces(MediaType.APPLICATION_JSON)
	public Book getBookById(@PathParam("id")  int id){
		return bookDao.getBookById(id);
	}
	
	//add book
//	@POST
//	@Produces("application/json")
//	@Consumes("application/json")
//	@Path("/books")
//	public Book addBook(Book book){
//		return bookDao.addBook(book);
//	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/books")
	public Response addBook(Book book){
		Book bookAdded= bookDao.addBook(book);
		return Response.status(201).entity(bookAdded).build();
	}
	
	
	//update the book
	@PUT
	@Produces("application/json")
	@Consumes("application/json")
	@Path("/books/{id}")
	public Book updateBook( @PathParam("id")  int id, Book book){
		return bookDao.updateBook(id, book);
	}
	
	//delete the book
	@DELETE
	@Path("/books/{id}")
	@Produces("application/json")
	public Response deleteBookById(@PathParam("id") int id){
		Book bookDeleted= bookDao.removeBook(id);
		return Response.status(204).build();
	}
}






