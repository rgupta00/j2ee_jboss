package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logic.AtmVerfify;
import com.logic.AtmVerfifyRemote;

@WebServlet("/atmCardControlller2")
public class AtmCardControlller2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	
	private AtmVerfifyRemote atmVerfifyRemote; 
	
	
	
	//pull: we are pulling the instance of ejb from the container
	
	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		try {
			InitialContext initialContext=new InitialContext();
			atmVerfifyRemote =(AtmVerfifyRemote)initialContext.lookup("java:global/atmcardapp/AtmVerfify!com.logic.AtmVerfifyRemote");
			
		} catch (NamingException e) {
			e.printStackTrace();
		}
		
	}



	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		out.print("atm card is valid or not?"+ atmVerfifyRemote.isValid("64656"));
	}
}
