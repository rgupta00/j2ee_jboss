package com.hello;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(
		activationConfig = { @ActivationConfigProperty(
				propertyName = "destination", propertyValue = "java:jboss/exported/jms/queue/testingQueue"), @ActivationConfigProperty(
				propertyName = "destinationType", propertyValue = "javax.jms.Queue")
		}, 
		mappedName = "java:jboss/exported/jms/queue/testingQueue")
public class HelloMdb implements MessageListener {

   
    public HelloMdb() {}
	
    public void onMessage(Message message) {
       System.out.println("");
       TextMessage msg = (TextMessage) message;
       String str=null;
		try {
			 str = msg.getText();
		} catch (JMSException e) {
			e.printStackTrace();
		}
		System.out.println("message recived: "+ str);
    }

}
