package ch.bfh.btx8081.interfaces;

import java.util.ArrayList;

import ch.bfh.btx8081.exceptions.PatientNotFoundException;
import ch.bfh.btx8081.exceptions.UsernameIsAlreadyTakenException;
import ch.bfh.btx8081.model.Activity;
import ch.bfh.btx8081.model.AvoidanceStrategy;
import ch.bfh.btx8081.model.DiaryManager;
import ch.bfh.btx8081.model.Doctor;
import ch.bfh.btx8081.model.Entry;
import ch.bfh.btx8081.model.Patient;

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

	public ArrayList<Patient> searchPatientOfDoctor(String searchQuery) throws PatientNotFoundException {
		return doctorInterface.searchPatientOfDoctor(doctor, searchQuery);
	}

	public ArrayList<Patient> getAllPatientsOfDoctor() {
		return doctorInterface.getAllPatientsOfDoctor(doctor);
	}

	public ArrayList<Entry> getDiaryEntries() {
		return doctorInterface.getDiaryEntries(currentPatient);
	}

	public void newDoctor(String firstName, String lastName, String phoneNumber, String eMail, String userName,
			String password) throws UsernameIsAlreadyTakenException {
		doctorInterface.newDoctor(firstName, lastName, phoneNumber, eMail, userName, password);
	}

	public void newPatient(String firstName, String lastName, String phoneNumber, String eMail, String userName,
			String password, String addiction, String mainInfo, String consumedSubstance,
			String consumptionMetric, String conditionAutomaticAlarm) throws UsernameIsAlreadyTakenException {
		doctorInterface.newPatient(firstName, lastName, phoneNumber, eMail, userName,
				password, addiction, mainInfo, doctor, consumedSubstance,
				consumptionMetric, conditionAutomaticAlarm);
	}

	public void changeContactInfo(String firstName, String lastName, String phoneNumber, String eMail) {
		doctorInterface.changeContactInfo(currentPatient, firstName, lastName, phoneNumber, eMail);
	}

	public void changeMainInfo(String newMainInfo) {
		doctorInterface.changeMainInfo(currentPatient, newMainInfo);
	}

	public void createNewActivity(String activity, String iconID) {
		doctorInterface.createNewActivity(currentPatient, activity, iconID);
	}

	public void removeNewActivity(Activity activity) {
		doctorInterface.removeNewActivity(currentPatient, activity);
	}

	public void createNewAvoidanceStrategy(String avoidanceStrategy) {
		doctorInterface.createNewAvoidanceStrategy(currentPatient, avoidanceStrategy);
	}

	public void removeNewAvoidanceStrategy(AvoidanceStrategy avoidanceStrategy) {
		doctorInterface.removeNewAvoidanceStrategy(currentPatient, avoidanceStrategy);
	}

	public void setConditionAutomaticAlarm(String conditionAutomaticAlarm) {
		doctorInterface.setConditionAutomaticAlarm(currentPatient, conditionAutomaticAlarm);
	}

//	getters & setters

	public Patient getCurrentPatient() {
		return currentPatient;
	}

	public void setCurrentPatient(Patient currentPatient) {
		this.currentPatient = currentPatient;
	}

	public Doctor getDoctor() {
		return doctor;
	}

}