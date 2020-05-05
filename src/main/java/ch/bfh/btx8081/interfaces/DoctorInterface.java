package ch.bfh.btx8081.interfaces;

import java.util.ArrayList;

import ch.bfh.btx8081.exceptions.UserNotFoundException;
import ch.bfh.btx8081.exceptions.WrongPasswordException;
import ch.bfh.btx8081.model.Activity;
import ch.bfh.btx8081.model.AvoidanceStrategy;
import ch.bfh.btx8081.model.Doctor;
import ch.bfh.btx8081.model.Entry;
import ch.bfh.btx8081.model.Patient;

public interface DoctorInterface {

	ArrayList<Patient> searchPatientOfDoctor(Doctor doctor, String SearchQuery);

	ArrayList<Patient> getAllPatientsOfDoctor(Doctor doctor);

	ArrayList<Entry> getDiaryEntries(Patient patient);

	void authenticate(String userName, String password) throws WrongPasswordException, UserNotFoundException;

	void newDoctor(String firstName, String lastName, String phoneNumber, String eMail, String userName,
			String password);

	void newPatient(String firstName, String lastName, String phoneNumber, String eMail, String userName,
			String password, String addiction, String mainInfo, Doctor doctor, String consumedSubstance,
			String consumptionMetric, String conditionAutomaticAlarm);

	void changeContactInfo(Patient patient, String firstName, String lastName, String phoneNumber, String eMail);

	void changeMainInfo(Patient patient, String newMainInfo);

	void createNewActivity(Patient patient, String activity, String iconID);

	void removeNewActivity(Patient patient, Activity activity);

	void createNewAvoidanceStrategy(Patient patient, String avoidanceStrategy);

	void removeNewAvoidanceStrategy(Patient patient, AvoidanceStrategy avoidanceStrategy);

	void setConditionAutomaticAlarm(Patient patient, String conditionAutomaticAlarm);
	
}
