package ch.bfh.btx8081.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
//@Table(name = "question")
public class QuestionForConsultation {
	
	@Id
	@GeneratedValue
	private Long id;
	private String question = "";
	
//	@OneToOne(cascade = CascadeType.ALL)
//	@JoinColumn(name = "entry_id")
//	private Entry entry;
	
	
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
