package ch.bfh.btx8081.exceptions;

public class WrongPasswordException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public WrongPasswordException() {
		super("Wrong password.");
	}

	public WrongPasswordException(String message) {
		super(message);
	}
	
}
