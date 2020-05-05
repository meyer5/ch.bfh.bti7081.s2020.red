package ch.bfh.btx8081.interfaces;

import ch.bfh.btx8081.model.Doctor;
import ch.bfh.btx8081.model.Patient;

public class DoctorService implements Service {

	private final Doctor doctor;
	private Patient currentPatient;

	public DoctorService(Doctor doctor) {
		super();
		this.doctor = doctor;
	}
	
	
	
//	getters & setters

	public Patient getCurrentPatient() {
		return currentPatient;
	}

	public void setCurrentPatient(Patient currentPatient) {
		this.currentPatient = currentPatient;
	}

	public Doctor getDoctor() {
		return doctor;
	}
	
}