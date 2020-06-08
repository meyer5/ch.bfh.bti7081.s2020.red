package ch.bfh.btx8081.gui.doctor.editPatient;

import ch.bfh.btx8081.model.Patient;

public interface EditPatientInterface {

	public void setPatient(Patient patient);

	public void addListener(EditPatientListener presenter);
	
	public void fillAllFields();

	public interface EditPatientListener {

		public void handleSaveClick(String firstName, String lastName, String phoneNumber, String eMail, String newMainInfo);

		public void handleCancelClick();

	}

}
