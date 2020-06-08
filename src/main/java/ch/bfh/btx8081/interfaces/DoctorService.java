package ch.bfh.btx8081.interfaces;

import java.util.List;

import ch.bfh.btx8081.exceptions.PatientNotFoundException;
import ch.bfh.btx8081.exceptions.UsernameIsAlreadyTakenException;
import ch.bfh.btx8081.model.Activity;
import ch.bfh.btx8081.model.Alarm;
import ch.bfh.btx8081.model.AvoidanceStrategy;
import ch.bfh.btx8081.model.Condition;
import ch.bfh.btx8081.model.DiaryManager;
import ch.bfh.btx8081.model.Doctor;
import ch.bfh.btx8081.model.Entry;
import ch.bfh.btx8081.model.Patient;
import ch.bfh.btx8081.model.QuestionForConsultation;

public class DoctorService implements Service {

	private final Doctor doctor;
	private Patient currentPatient = null;
	private DoctorInterface doctorInterface = DiaryManager.getInstance();

	public DoctorService(Doctor doctor) {
		super();
		this.doctor = doctor;
	}

//	Interface

	public void selectPatient(Patient patient) {
		this.currentPatient = patient;
	}

	public List<Patient> searchPatientOfDoctor(String searchQuery) throws PatientNotFoundException {
		return doctorInterface.searchPatientOfDoctor(doctor, searchQuery);
	}

	public List<Patient> getAllPatientsOfDoctor() {
		return doctorInterface.getAllPatientsOfDoctor(doctor);
	}

	@Override
	public List<Entry> getDiaryEntries() {
		return doctorInterface.getDiaryEntries(currentPatient);
	}

	public void newDoctor(String firstName, String lastName, String phoneNumber, String eMail, String userName,
			String password) throws UsernameIsAlreadyTakenException {
		doctorInterface.newDoctor(firstName, lastName, phoneNumber, eMail, userName, password);
	}

	public void newPatient(String firstName, String lastName, String phoneNumber, String eMail, String userName,
			String password, String addiction, String mainInfo, String consumedSubstance,
			String consumptionMetric) throws UsernameIsAlreadyTakenException {
		doctorInterface.newPatient(firstName, lastName, phoneNumber, eMail, userName,
				password, addiction, mainInfo, doctor, consumedSubstance,
				consumptionMetric);
	}

	public void changeContactInfo(String firstName, String lastName, String phoneNumber, String eMail) {
		doctorInterface.changeContactInfo(currentPatient, firstName, lastName, phoneNumber, eMail);
	}

	public void changeMainInfo(String newMainInfo) {
		doctorInterface.changeMainInfo(currentPatient, newMainInfo);
	}

	@Override
	public void createNewActivity(String activity, String iconID) {
		doctorInterface.createNewActivity(currentPatient, activity, iconID);
	}

	@Override
	public void removeNewActivity(Activity activity) {
		doctorInterface.removeNewActivity(currentPatient, activity);
	}

	@Override
	public void createNewAvoidanceStrategy(String avoidanceStrategy) {
		doctorInterface.createNewAvoidanceStrategy(currentPatient, avoidanceStrategy);
	}

	@Override
	public void removeNewAvoidanceStrategy(AvoidanceStrategy avoidanceStrategy) {
		doctorInterface.removeNewAvoidanceStrategy(currentPatient, avoidanceStrategy);
	}
	
	@Override
	public void createNewQuestionForConsultation(String questionForConsultation) {
		doctorInterface.createNewQuestionForConsultation(currentPatient, questionForConsultation);
		
	}

	@Override
	public void removeNewQuestionForConsultation(QuestionForConsultation questionForConsultation) {
		doctorInterface.removeNewQuestionForConsultation(currentPatient, questionForConsultation);
	}

	public void setConditionAutomaticAlarm(Condition conditionAutomaticAlarm) {
		doctorInterface.setConditionAutomaticAlarm(currentPatient, conditionAutomaticAlarm);
	}
	
	public void removeConditionAutomaticAlarm() {
		doctorInterface.removeConditionAutomaticAlarm(currentPatient);
	}
	
	public void removeAlarm(Alarm alarm) {
		doctorInterface.removeAlarm(doctor, alarm);
	}

//	getters & setters

	public Patient getPatient() {
		return currentPatient;
	}

	public void setCurrentPatient(Patient currentPatient) {
		this.currentPatient = currentPatient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

	

}