package ch.bfh.btx8081.gui.patient;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Presenter implements ViewListenerInterface {

	
	private BigDecimal consumption;
	private double motivation;
	private String comment;
	private String questions;
	private double pressure;
	
	private boolean confirmed;
	private LocalDate date;
	
	//TODO Input validation
	// Fragen -> leerer String oder NULL
	
	public Presenter() {
		super();
		this.consumption = new BigDecimal(0);
		this.motivation = 0.0;
		this.comment = "";
		this.questions = "";
		this.pressure = 0.0;
		this.confirmed = false;
		this.date = LocalDate.now();
	}

	@Override
	public void nextBtnClicked(String viewName, double number) {
				
		if(viewName.equals("Pressure")) {
			setPressure(number);
			// to check if it works...
			System.out.println("Pressure: " + number);
		}
		if(viewName.equals("Motivation")) {
			setMotivation(number);
			// to check if it works...
			System.out.println("Motivation: " + number);
		}
	}

	@Override
	public void nextBtnClicked(String viewName, BigDecimal consumption) {
		setConsumption(consumption);
		// to check if it works...
		System.out.println(consumption);
	}

	@Override
	public void nextBtnClicked(String viewName, String input) {
		
		if(viewName.equals("Comments")) {
			setComment(input);;
			System.out.println("Comment: " + input);
		}
		if (viewName.equals("Question")) {
			setQuestions(input);
			System.out.println("Question: " + input);
		}
		
	}
	
	public void nextBtnClicked(String viewName, boolean confirm) {
		setConfirmed(true);
		System.out.println(confirm);
	}
	
	public void nextBtnClicked(String viewName, LocalDate entryDate) {
		setDate(entryDate);
		System.out.println(entryDate);
	}

	

	public BigDecimal getConsumption() {
		return consumption;
	}

	public double getMotivation() {
		return motivation;
	}

	public String getComment() {
		return comment;
	}

	public String getQuestions() {
		return questions;
	}

	public double getPressure() {
		return pressure;
	}
	
	public boolean isConfirmed() {
		return confirmed;
	}

	
	private void setConsumption(BigDecimal consumption) {
		this.consumption = consumption;
	}

	private void setMotivation(double motivation) {
		this.motivation = motivation;
	}

	private void setComment(String comment) {
		this.comment = comment;
	}

	private void setQuestions(String questions) {
		this.questions = questions;
	}

	private void setPressure(double pressure) {
		this.pressure = pressure;
	}

	private void setConfirmed(boolean confirmed) {
		this.confirmed = confirmed;
	}

	private void setDate(LocalDate date) {
		this.date = date;
	}

	
	

	

	

	
	
	
	
}
