package ch.bfh.btx8081.model;

import java.time.LocalDate;

public class UrgentCaseAlarm extends Alarm {

//	Constructor for persistence
	public UrgentCaseAlarm(Patient patient, String type, String message, LocalDate date) {
		super(patient, type, message, date);
	}

//	Constructor for application
	public UrgentCaseAlarm(Patient patient, String message) {
		super(patient, "Urgent case", message, LocalDate.now());
		super.send();
	}
}