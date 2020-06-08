package ch.bfh.btx8081.model;

import java.time.LocalDate;

public abstract class Alarm {

	private Patient patient;
	private String type;
	private String message;
	private LocalDate date;
	
	
	
	public Alarm(Patient patient, String type, String message, LocalDate date) {
		this.patient = patient;
		this.type = type;
		this.message = message;
		this.date = date;
	}

	void send() {
		this.patient.getDoctor().addAlarm(this);
	}

	public Patient getPatient() {
		return patient;
	}

	protected void setPatient(Patient patient) {
		this.patient = patient;
	}
	
	public String getType() {
		return type;
	}

	protected void setType(String type) {
		this.type = type;
	}

	public String getMessage() {
		return message;
	}

	protected void setMessage(String message) {
		this.message = message;
	}

	public LocalDate getDate() {
		return date;
	}

	protected void setDate(LocalDate date) {
		this.date = date;
	}
	
	public String getFirstName() {
		return patient.getFirstName();
	}
	
	public String getLastName() {
		return patient.getLastName();
	}
}
