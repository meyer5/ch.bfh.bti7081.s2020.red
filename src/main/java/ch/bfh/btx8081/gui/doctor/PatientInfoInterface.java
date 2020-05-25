package ch.bfh.btx8081.gui.doctor;

public interface PatientInfoInterface {

	public void setPatient();

	public void addListener(PatientInfoListener presenter);

	public interface PatientInfoListener {

		public void hadleActivitiesClick();

		public void hadleStrategiesClick();

		public void hadleQuestionsClick();

		public void hadleOpenEntryClick();

		public void hadleEntriesListClick();

		public void hadleBackClick();

	}

}
