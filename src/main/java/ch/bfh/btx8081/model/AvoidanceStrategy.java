package ch.bfh.btx8081.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
//@Table(name = "strategy")
public class AvoidanceStrategy {
	@Id
	private String strategy = "";
	
	@ManyToOne
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
