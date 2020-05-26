package ch.bfh.btx8081.model;

import java.util.ArrayList;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
//@Table(name = "doctor")
public class Doctor extends User{
	
	// ArrayList geht nicht, Fehlermeldung
	@OneToMany(mappedBy = "doctor",	cascade = CascadeType.PERSIST)
	private List<Patient> patients =  new ArrayList<Patient>();

//	Constructor for JPA
	public Doctor() {
		
	}
	
//	Constructor for persistence
	public Doctor(String firstName, String lastName, String phoneNumber, String eMail, String userName, String password,
			ArrayList<Patient> patients) {
		super(firstName, lastName, phoneNumber, eMail, userName, password);
		this.patients = patients;
	}
	
//	Constructor for database testing
	public Doctor(String firstName, String lastName, String phoneNumber, String eMail, String userName, String password) {
		super(firstName, lastName, phoneNumber, eMail, userName, password);
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
	
	public List<Patient> getPatients() {
		return patients;
	}

	protected void setPatients(ArrayList<Patient> patients) {
		this.patients = patients;
	}

}
