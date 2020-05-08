package ch.bfh.btx8081.exceptions;

public class UsernameIsAlreadyTakenException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public UsernameIsAlreadyTakenException() {
		super("This username is already taken.");
	}

	public UsernameIsAlreadyTakenException(String message) {
		super(message);
	}
	
}