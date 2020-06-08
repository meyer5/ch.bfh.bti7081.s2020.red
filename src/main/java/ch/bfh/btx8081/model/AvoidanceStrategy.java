package ch.bfh.btx8081.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
//@Table(name = "strategy")
public class AvoidanceStrategy {
	@Id
	@GeneratedValue
	private Long id;
	private String strategy = "";
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "diary_id")
	private Diary diary;

//	Constructor for JPA
	public AvoidanceStrategy() {
	
	}
	
	protected AvoidanceStrategy(String strategy) {
		super();
		this.strategy = strategy;
	}
	
//	getters & setters
	
	public String getStrategy() {
		return strategy;
	}

	protected void setStrategy(String strategy) {
		this.strategy = strategy;
	}
	
	

}
