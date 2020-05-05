package ch.bfh.btx8081.exceptions;

public class ShowAvoidanceStrategyException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public ShowAvoidanceStrategyException() {
		super("Show avoidance strategy.");
	}

	public ShowAvoidanceStrategyException(String message) {
		super(message);
	}
	
}