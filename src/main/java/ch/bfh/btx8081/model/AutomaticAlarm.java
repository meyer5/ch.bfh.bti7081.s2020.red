package ch.bfh.btx8081.model;

import java.time.LocalDate;

public class AutomaticAlarm extends Alarm {

//	Constructor for persistence
	public AutomaticAlarm(Patient patient, String type, String message, LocalDate date) {
		super(patient, type, message, date);
	}

//	Constructor for application
	public AutomaticAlarm(Patient patient) {
		super(patient, "Automatic", "Was automatically triggered", LocalDate.now());
		super.send();
	}
}