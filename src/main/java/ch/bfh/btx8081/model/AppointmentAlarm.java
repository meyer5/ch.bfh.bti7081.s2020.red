package ch.bfh.btx8081.model;

import java.time.LocalDate;

public class AppointmentAlarm extends Alarm {

//	Constructor for persistence
	public AppointmentAlarm(Patient patient, String type, String message, LocalDate date) {
		super(patient, type, message, date);
	}

//	Constructor for application
	public AppointmentAlarm(Patient patient, String message) {
		super(patient, "Appointment", message, LocalDate.now());
		super.send();
	}
}
