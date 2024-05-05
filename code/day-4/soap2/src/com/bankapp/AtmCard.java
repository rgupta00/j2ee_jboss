package com.bankapp;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlRootElement;

//SOAP based web service use something call jaxb: used to convert java to xml and xml to java

@XmlRootElement(name="atmCard")
@XmlAccessorType(XmlAccessType.FIELD)
public class AtmCard {
	@XmlAttribute(required=true)
	private String number;
	@XmlAttribute(required=true)
	private String customerName;
	@XmlAttribute(required=true)
	private String bankName;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public AtmCard(String number, String customerName, String bankName) {
		super();
		this.number = number;
		this.customerName = customerName;
		this.bankName = bankName;
	}
	public AtmCard() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
