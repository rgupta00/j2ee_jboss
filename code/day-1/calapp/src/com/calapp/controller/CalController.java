package com.calapp.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.calapp.model.Calculator;

@WebServlet("/CalController")
public class CalController extends HttpServlet {
	private static final long serialVersionUID = 1L;
     
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Integer x=Integer.parseInt(request.getParameter("x"));
		Integer y=Integer.parseInt(request.getParameter("y"));
		
//		Integer sum=x+y;
		Calculator calculator=new Calculator();
		
		Integer sum=calculator.add(x, y);
		
//		PrintWriter out=response.getWriter();
//		out.print("value of sum is "+ sum);
		//I need to trasnfer the control to jsp and pass the result ie sum to the jsp
		RequestDispatcher rd=request.getRequestDispatcher("show.jsp");
		request.setAttribute("sum", sum);
		rd.forward(request, response);
		
	}

}



//@Override
//public void init(ServletConfig config) throws ServletException {
//	// TODO Auto-generated method stub
//	super.init(config);
//	System.out.println("init method is called");
//}
//
//
//
//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	
//	PrintWriter out=response.getWriter();
//	out.print(LocalDateTime.now());
//	
//	System.out.println("do get method is called");
//}
//
//
//@Override
//public void destroy() {
//	System.out.println("destory method is called");
//}
