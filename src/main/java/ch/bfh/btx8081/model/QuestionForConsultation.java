package ch.bfh.btx8081.model;

public class QuestionForConsultation {
	
	private String question = "";

	public QuestionForConsultation(String question) {
		super();
		this.question = question;
	}
	
//	getters & setters

	public String getQuestion() {
		return question;
	}

	protected void setQuestion(String question) {
		this.question = question;
	}
	
	

}
