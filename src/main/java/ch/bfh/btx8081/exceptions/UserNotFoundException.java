package ch.bfh.btx8081.exceptions;

public class UserNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public UserNotFoundException() {
		super("User not found.");
	}

	public UserNotFoundException(String message) {
		super(message);
	}
	
}