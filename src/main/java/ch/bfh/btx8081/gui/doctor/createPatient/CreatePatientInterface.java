package ch.bfh.btx8081.gui.doctor.createPatient;

public interface CreatePatientInterface {

	public void addListener(CreatePatientListener presenter);
	
	public void userNameAlreadyTaken();
	
	public void fillAllFields();

	public interface CreatePatientListener {

		public void handleSaveClick(String firstName, String lastName, String phoneNumber, String eMail, String userName, String password, String addiction, String mainInfo, String consumedSubstance, String consumptionMetric);

		public void hadleCancelClick();

	}

}
