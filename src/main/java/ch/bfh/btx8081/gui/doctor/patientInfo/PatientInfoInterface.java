package ch.bfh.btx8081.gui.doctor.patientInfo;

import ch.bfh.btx8081.model.Entry;
import ch.bfh.btx8081.model.Patient;

public interface PatientInfoInterface {

	public void setPatient(Patient patient);

	public void addListener(PatientInfoListener presenter);

	public interface PatientInfoListener {

		public void hadleActivitiesClick();

		public void hadleStrategiesClick();

		public void hadleQuestionsClick();
		
		public void hadleAutomaticAlarmClick();

		public void hadleOpenEntryClick(Entry entry);

		public void hadleEntriesListClick();
		
		public void hadleEditClick();
		
		public void hadleLogOutClick();

		public void hadleBackClick();

	}

}
