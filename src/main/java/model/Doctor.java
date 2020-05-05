package model;

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
	public Doctor(long id, String firstName, String lastName, String phoneNumber, String eMail, String userName, String password) {
		super(id, firstName, lastName, phoneNumber, eMail, userName, password);
	}
	
//	adder & remover
	
	public void addPatient(Patient patient) {
		this.patients.add(patient);
	}
	
	public void removePatient(Patient patient) {
		this.patients.remove(patient);
	}
	
//	getters & setters
	
	public ArrayList<Patient> getPatients() {
		return patients;
	}

	public void setPatients(ArrayList<Patient> patients) {
		this.patients = patients;
	}

}
