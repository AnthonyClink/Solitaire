package com.stevesmith.solitaire.exception;

public class ApiMisuseException extends Exception {

	private static final long serialVersionUID = 4455508317484909836L;
	
	public ApiMisuseException(String message){
		super(message);
	}
}
