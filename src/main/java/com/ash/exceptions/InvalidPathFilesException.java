package com.ash.exceptions;

@SuppressWarnings("serial")
public class InvalidPathFilesException extends FrameWorkException{

	public InvalidPathFilesException(String message) {
		super(message);
	}

	public InvalidPathFilesException(String message,Throwable cause)
	{
		super(message,cause);
	}
}
