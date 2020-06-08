package ch.bfh.btx8081.exceptions;

public class AutomaticAlarmException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public AutomaticAlarmException() {
		super("Send automatic alarm");
	}

	public AutomaticAlarmException(String message) {
		super(message);
	}

}
