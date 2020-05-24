package ch.bfh.btx8081.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
//@Table(name = "question")
public class QuestionForConsultation {
	
	@Id
	private String question = "";
	
	@OneToOne
	private Entry entry;
	
	
//	Constructor for JPA
	public QuestionForConsultation() {
		
	}
	
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
