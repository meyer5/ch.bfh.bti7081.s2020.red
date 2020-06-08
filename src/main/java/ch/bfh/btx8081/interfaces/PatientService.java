package ch.bfh.btx8081.interfaces;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import ch.bfh.btx8081.exceptions.ShowAvoidanceStrategyException;
import ch.bfh.btx8081.model.Activity;
import ch.bfh.btx8081.model.AvoidanceStrategy;
import ch.bfh.btx8081.model.DiaryManager;
import ch.bfh.btx8081.model.Entry;
import ch.bfh.btx8081.model.Patient;
import ch.bfh.btx8081.model.QuestionForConsultation;

public class PatientService implements Service {

	private final Patient patient;
	private PatientInterface patientInterface = DiaryManager.getInstance();

	public PatientService(Patient patient) {
		super();
		this.patient = patient;
	}

//	Interface

	@Override
	public List<Entry> getDiaryEntries() {
		return patientInterface.getDiaryEntries(patient);
	}

	@Override
	public void createNewActivity(String activity, String iconID) {
		patientInterface.createNewActivity(patient, activity, iconID);
	}

	@Override
	public void removeNewActivity(Activity activity) {
		patientInterface.removeNewActivity(patient, activity);
	}

	@Override
	public void createNewAvoidanceStrategy(String avoidanceStrategy) {
		patientInterface.createNewAvoidanceStrategy(patient, avoidanceStrategy);
	}

	@Override
	public void removeNewAvoidanceStrategy(AvoidanceStrategy avoidanceStrategy) {
		patientInterface.removeNewAvoidanceStrategy(patient, avoidanceStrategy);
	}
	
	@Override
	public void createNewQuestionForConsultation(String questionForConsultation) {
		patientInterface.createNewQuestionForConsultation(patient, questionForConsultation);
		
	}

	@Override
	public void removeNewQuestionForConsultation(QuestionForConsultation questionForConsultation) {
		patientInterface.removeNewQuestionForConsultation(patient, questionForConsultation);
		
	}

	public void newEntry(LocalDate date, long consumption, int pressureToConsume, int motivation,
			ArrayList<Activity> activities, String comment, String questionForConsultation)
			throws ShowAvoidanceStrategyException {
		patientInterface.newEntry(date, patient, consumption, pressureToConsume, motivation, activities, comment,
				questionForConsultation);
	}
	
	public AvoidanceStrategy getRandomAvoidanceStrategy() {
		return patientInterface.getRandomAvoidanceStrategy(patient);
	}
	
	public void sendUrgentCaseAlarm(String message) {
		patientInterface.sendUrgentCaseAlarm(patient, message);
	}

	public void sendAppontmentAlarm(String message) {
		patientInterface.sendAppontmentAlarm(patient, message);
	}


//	getters & setters

	public Patient getPatient() {
		return patient;
	}

}
