package ch.bfh.btx8081.model;

public class AvoidanceStrategy {
	
	private String strategy = "";

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
