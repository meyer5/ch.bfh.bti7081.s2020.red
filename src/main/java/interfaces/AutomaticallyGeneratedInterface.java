package interfaces;

import java.util.ArrayList;

import exceptions.ShowAvoidanceStrategyException;
import exceptions.UserNotFoundException;
import exceptions.WrongPasswordException;
import model.Activity;
import model.AvoidanceStrategy;
import model.Doctor;
import model.Entry;
import model.Patient;
import model.QuestionForConsultation;
import model.User;

public interface AutomaticallyGeneratedInterface {

	User searchUserByUsername(String userName) throws UserNotFoundException;

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

	void newEntry(Patient patient, int mood, long consumption, int pressureToConsume, int motivation,
			ArrayList<Activity> activities, String comment, QuestionForConsultation questionForConsultation)
			throws ShowAvoidanceStrategyException;

	void save(Doctor doctor);

	void save(Patient patient);

	void addDoctor(Doctor doctor);

	void removeDoctor(Doctor doctor);

	ArrayList<Doctor> getDoctors();

	void setDoctors(ArrayList<Doctor> doctors);

}