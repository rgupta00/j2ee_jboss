package com.jmsapp.controller;

import java.io.IOException;

import javax.ejb.EJB;
import javax.jms.JMSException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jmsapp.producer.HelloMessageConsumerLocal;

@WebServlet("/helloMsgController")
public class HelloMsgController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	@EJB
	private HelloMessageConsumerLocal helloMessageConsumerLocal;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			helloMessageConsumerLocal.sendMessage("i love java ee with jboss eap");
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}


}
