package ch.bfh.btx8081.exceptions;

public class InputNotAllowedException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public InputNotAllowedException() {
		super("Input not alowed.");
	}

	public InputNotAllowedException(String message) {
		super(message);
	}
	
}
