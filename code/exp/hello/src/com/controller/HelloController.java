package com.controller;

import java.io.IOException;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/HelloController")
public class HelloController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Context ctx;
		Queue ShipmentQueue = null;
		try {
			ctx = new InitialContext(System.getProperties());
			ShipmentQueue = (javax.jms.Queue) ctx.lookup("java:jboss/exported/jms/queue/testingQueue");
			ConnectionFactory factory = (ConnectionFactory) ctx.lookup("java:/ConnectionFactory");
			Connection JmsCon = factory.createConnection();
			Session JmsSession = JmsCon.createSession(false, Session.AUTO_ACKNOWLEDGE);

			// Sample 9.12: Format the Message String
			String data = "hello message";

			// Sample 9.13: Post Message Data to the Queue
			MessageProducer sender = JmsSession.createProducer(ShipmentQueue);
			TextMessage TextMsg = JmsSession.createTextMessage();
			TextMsg.setText(data);
			sender.send(TextMsg);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}
