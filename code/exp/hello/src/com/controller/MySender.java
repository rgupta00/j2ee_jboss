package com.controller;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

@Stateless
public class MySender implements MySenderLocal {

	@Resource(mappedName = "java:/ConnectionFactory") 
	private ConnectionFactory factory;

	@Resource(mappedName = "java:jboss/exported/jms/queue/testingQueue")
	private Queue target;

	// Sends the given string as text message:
	public void sendMessage(String txt) throws JMSException {
		Connection con = factory.createConnection();
		try {
			Session session = con.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer producer = session.createProducer(target);
			producer.send(session.createTextMessage(txt));
		} finally {
			con.close();
		}
	}
}