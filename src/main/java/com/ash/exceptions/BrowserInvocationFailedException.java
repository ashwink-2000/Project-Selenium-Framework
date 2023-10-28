package com.ash.exceptions;

@SuppressWarnings("serial")
public class BrowserInvocationFailedException extends FrameWorkException{

	public BrowserInvocationFailedException(String message)
	{
		super(message);
	}
	
	public BrowserInvocationFailedException(String message,Throwable cause)
	{
		super(message,cause);
	}
}
