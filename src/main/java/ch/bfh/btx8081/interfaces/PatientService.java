package ch.bfh.btx8081.interfaces;

import java.util.ArrayList;
import java.util.List;

import ch.bfh.btx8081.exceptions.ShowAvoidanceStrategyException;
import ch.bfh.btx8081.model.Activity;
import ch.bfh.btx8081.model.AvoidanceStrategy;
import ch.bfh.btx8081.model.DiaryManager;
import ch.bfh.btx8081.model.Entry;
import ch.bfh.btx8081.model.Patient;

public class PatientService implements Service {

	private final Patient patient;
	private PatientInterface patientInterface = DiaryManager.getInstance();

	public PatientService(Patient patient) {
		super();
		this.patient = patient;
	}

//	Interface

	public List<Entry> getDiaryEntries() {
		return patientInterface.getDiaryEntries(patient);
	}

	public void createNewActivity(String activity, String iconID) {
		patientInterface.createNewActivity(patient, activity, iconID);
	}

	public void removeNewActivity(Activity activity) {
		patientInterface.removeNewActivity(patient, activity);
	}

	public void createNewAvoidanceStrategy(String avoidanceStrategy) {
		patientInterface.createNewAvoidanceStrategy(patient, avoidanceStrategy);
	}

	public void removeNewAvoidanceStrategy(AvoidanceStrategy avoidanceStrategy) {
		patientInterface.removeNewAvoidanceStrategy(patient, avoidanceStrategy);
	}

	public void newEntry(int mood, long consumption, int pressureToConsume, int motivation,
			ArrayList<Activity> activities, String comment, String questionForConsultation)
			throws ShowAvoidanceStrategyException {
		patientInterface.newEntry(patient, consumption, pressureToConsume, motivation, activities, comment,
				questionForConsultation);
	}

//	getters & setters

	public Patient getPatient() {
		return patient;
	}

}
