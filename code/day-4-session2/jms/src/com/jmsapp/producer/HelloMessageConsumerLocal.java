package com.jmsapp.producer;

import javax.ejb.Local;
import javax.jms.JMSException;

@Local
public interface HelloMessageConsumerLocal {
		void sendMessage(String message) throws JMSException;
}
