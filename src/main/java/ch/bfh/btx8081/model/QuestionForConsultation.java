package ch.bfh.btx8081.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name = "Question")
@Table(name = "question")
public class QuestionForConsultation {
	
	@Id
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
