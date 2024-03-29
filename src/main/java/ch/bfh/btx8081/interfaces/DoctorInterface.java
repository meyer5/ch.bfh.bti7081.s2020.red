package ch.bfh.btx8081.interfaces;

import java.util.List;

import ch.bfh.btx8081.exceptions.PatientNotFoundException;
import ch.bfh.btx8081.exceptions.UsernameIsAlreadyTakenException;
import ch.bfh.btx8081.model.Activity;
import ch.bfh.btx8081.model.Alarm;
import ch.bfh.btx8081.model.AvoidanceStrategy;
import ch.bfh.btx8081.model.Condition;
import ch.bfh.btx8081.model.Doctor;
import ch.bfh.btx8081.model.Entry;
import ch.bfh.btx8081.model.Patient;
import ch.bfh.btx8081.model.QuestionForConsultation;

public interface DoctorInterface {

	List<Patient> searchPatientOfDoctor(Doctor doctor, String searchQuery) throws PatientNotFoundException;

	List<Patient> getAllPatientsOfDoctor(Doctor doctor);

	List<Entry> getDiaryEntries(Patient patient);

	void newDoctor(String firstName, String lastName, String phoneNumber, String eMail, String userName,
			String password) throws UsernameIsAlreadyTakenException;

	void newPatient(String firstName, String lastName, String phoneNumber, String eMail, String userName,
			String password, String addiction, String mainInfo, Doctor doctor, String consumedSubstance,
			String consumptionMetric) throws UsernameIsAlreadyTakenException;

	void changeContactInfo(Patient patient, String firstName, String lastName, String phoneNumber, String eMail);

	void changeMainInfo(Patient patient, String newMainInfo);

	void createNewActivity(Patient patient, String activity, String iconID);

	void removeNewActivity(Patient patient, Activity activity);

	void createNewAvoidanceStrategy(Patient patient, String avoidanceStrategy);

	void removeNewAvoidanceStrategy(Patient patient, AvoidanceStrategy avoidanceStrategy);
	
	void createNewQuestionForConsultation(Patient patient, String questionForConsultation);

	void removeNewQuestionForConsultation(Patient patient, QuestionForConsultation questionForConsultation);

	void setConditionAutomaticAlarm(Patient patient, Condition conditionAutomaticAlarm);
	
	void removeConditionAutomaticAlarm(Patient patient);
	
	void removeAlarm(Doctor doctor, Alarm alarm);
	
}
