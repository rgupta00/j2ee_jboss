package com.controller;

import javax.ejb.Local;
import javax.jms.JMSException;

@Local
public interface MySenderLocal {
  void sendMessage(String txt) throws JMSException;
}
