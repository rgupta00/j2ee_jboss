package com.bookstore.providers;

import java.time.LocalDateTime;

import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import com.bookstore.dto.ErrorMessage;
import com.bookstore.exceptions.BookNotFoundException;

@Provider
public class BookNotFoundExceptionProvider implements ExceptionMapper<BookNotFoundException>{

	@Override
	public Response toResponse(BookNotFoundException ex) {
		ErrorMessage errorMessage=new ErrorMessage();
		errorMessage.setDateTime(LocalDateTime.now());
		errorMessage.setMessage("book not found");
		errorMessage.setStatusCode("404");
		errorMessage.setToContact("rgupta.metch@gmail.com");
		
		return Response.status(404).entity(errorMessage).build();
	}

}
