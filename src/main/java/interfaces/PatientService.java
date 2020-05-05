package interfaces;

import model.Patient;

public class PatientService implements Service {
	
	private final Patient patient;

	public PatientService(Patient patient) {
		super();
		this.patient = patient;
	}

//	getters & setters
	
	public Patient getPatient() {
		return patient;
	}

}
