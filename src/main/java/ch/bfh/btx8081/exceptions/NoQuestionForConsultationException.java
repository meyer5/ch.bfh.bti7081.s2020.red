package ch.bfh.btx8081.exceptions;

public class NoQuestionForConsultationException extends Exception{

	private static final long serialVersionUID = 1L;
	
	public NoQuestionForConsultationException() {
		super("No question for consultation in this entry.");
	}

	public NoQuestionForConsultationException(String message) {
		super(message);
	}
	
}
