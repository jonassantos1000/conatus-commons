package br.com.app.conatus.commons.exceptions;

public class MsgException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;
	
	public MsgException(String mensagem) {
		super(mensagem);
	}
}
