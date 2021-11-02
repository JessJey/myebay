package it.prova.myebay.exception;


public class CreditoIns extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public CreditoIns(String message) {
		super(message);
	}

}