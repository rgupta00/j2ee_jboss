package com.jmsapp.producer;

import javax.annotation.Resource;
import javax.ejb.Stateless;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Queue;
import javax.jms.Session;

@Stateless
public class HelloMessageConsumer implements HelloMessageConsumerLocal {

	// java:jboss/exported/jms/queue/testingQueue

	// connectionfactory
	@Resource(mappedName = "java:/ConnectionFactory")
	private ConnectionFactory connectionFactory;

	// Queue
	@Resource(mappedName = "java:jboss/exported/jms/queue/testingQueue")
	private Queue queue;

	@Override
	public void sendMessage(String message) throws JMSException {
		Connection connection = connectionFactory.createConnection();
		try {
			Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
			MessageProducer messageProducer = session.createProducer(queue);
			messageProducer.send(session.createTextMessage(message));
		} finally {
			connection.close();
		}
	}

}
