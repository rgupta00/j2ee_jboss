package com.jmsapp.consumer;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(
		activationConfig = { 
				@ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:jboss/exported/jms/queue/testingQueue"), 
				@ActivationConfigProperty(propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "java:jboss/exported/jms/queue/testingQueue")
public class HelloConsumer implements MessageListener {

    public void onMessage(Message message) {
       //i just need to recived the message and process it ... print it
    	TextMessage msg= (TextMessage) message;
    	String data=null;
    	try {
    		data= msg.getText();
    		System.out.println(data);
    	}catch(JMSException e) {
    		e.printStackTrace();
    	}
    	System.out.println("message is recived");
    }

}
