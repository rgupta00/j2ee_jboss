package com.calapp;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@SOAPBinding(style=Style.RPC, use=Use.LITERAL)
@WebService(name="calculatorapplication", portName="calPort", targetNamespace="com.myapp.calapp")
public class Calculator {
	
	@WebMethod(operationName="addOpt", action="addAction")
	@WebResult(name="addResult")
	public int add(@WebParam(name="a") int a, @WebParam(name="b") int b) {
		return a+b;
	}

	@WebMethod(operationName="mulOpt", action="mulAction")
	@WebResult(name="mulResult")
	public int mul(@WebParam(name="a") int a, @WebParam(name="b") int b) {
		return a*b;
	}
}
