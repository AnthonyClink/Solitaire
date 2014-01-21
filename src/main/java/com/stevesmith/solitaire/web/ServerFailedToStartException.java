package com.stevesmith.solitaire.web;

public class ServerFailedToStartException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9121518818532885320L;
	
	public ServerFailedToStartException(Exception e){
		super("Jetty failed to start");
		System.err.append(e.getLocalizedMessage());
			
		for(Object stackItem : getStackTrace()){
			System.err.append(stackItem.toString());
		}
		
		
	}

}
