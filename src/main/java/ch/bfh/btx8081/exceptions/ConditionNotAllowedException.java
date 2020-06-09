package ch.bfh.btx8081.exceptions;

public class ConditionNotAllowedException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public ConditionNotAllowedException() {
		super("Input not alowed.");
	}

	public ConditionNotAllowedException(String message) {
		super(message);
	}
	
}
