package com.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.logic.AtmVerfify;
import com.logic.AtmVerfifyRemote;

@WebServlet("/atmCardControlller")
public class AtmCardControlller extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private AtmVerfifyRemote atmVerfifyRemote; //push approach
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		out.print("atm card is valid or not?"+ atmVerfifyRemote.isValid("64656"));
	}
}
