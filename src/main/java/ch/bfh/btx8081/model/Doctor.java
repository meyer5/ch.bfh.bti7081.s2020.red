package ch.bfh.btx8081.model;

import java.util.ArrayList;

public class Doctor extends User{
	
	private ArrayList<Patient> patients =  new ArrayList<Patient>();

//	Constructor for persistence
	public Doctor(long id, String firstName, String lastName, String phoneNumber, String eMail, String userName, String password,
			ArrayList<Patient> patients) {
		super(id, firstName, lastName, phoneNumber, eMail, userName, password);
		this.patients = patients;
	}
	
//	Constructor for new doctor
	protected Doctor(long id, String firstName, String lastName, String phoneNumber, String eMail, String userName, String password) {
		super(id, firstName, lastName, phoneNumber, eMail, userName, password);
	}
	
//	adder & remover
	
	protected void addPatient(Patient patient) {
		this.patients.add(patient);
	}
	
	protected void removePatient(Patient patient) {
		this.patients.remove(patient);
	}
	
//	getters & setters
	
	public ArrayList<Patient> getPatients() {
		return patients;
	}

	protected void setPatients(ArrayList<Patient> patients) {
		this.patients = patients;
	}

}
