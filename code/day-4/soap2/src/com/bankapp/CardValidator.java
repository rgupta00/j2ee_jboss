package com.bankapp;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;
import javax.jws.soap.SOAPBinding.Use;

@SOAPBinding(style = Style.RPC, use = Use.LITERAL)
@WebService(name = "CardValidatorService", portName = "CardValidatorPort", targetNamespace = "com.myapp.cardapp")
public class CardValidator {

	@WebResult(name = "isCardValid")
	@WebMethod(operationName = "cardValidator")
	public boolean validate(@WebParam(name = "atmCard") AtmCard atmCard) {
		String atmCarNo = atmCard.getNumber();
		// lots of logic we have to write
		try {
			int val = Integer.parseInt(atmCarNo);
			return val % 2 == 0;
		} catch (Exception e) {
			throw new InvalidCardException("card is invalid");
		}
	}

}
