package com.bookstore.controller;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

@Path("api")
public class HelloController {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public String hello() {
		return "hello all!";
	}
	
//	@GET
//	@Path(("/{param}"))
//	@Produces(MediaType.TEXT_PLAIN)
//	public String helloPathParma(@PathParam("param")String param) {
//		return "hello all! "+ param;
//	}
//	
//	@GET
//	@Produces(MediaType.TEXT_PLAIN)
//	public String helloQueryParam(@QueryParam("customerId")String customerId) {
//		return "hello all! "+ customerId;
//	}
}
