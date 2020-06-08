package ch.bfh.btx8081.interfaces;

import java.time.LocalDate;
import java.util.List;

import ch.bfh.btx8081.exceptions.ShowAvoidanceStrategyException;
import ch.bfh.btx8081.model.Activity;
import ch.bfh.btx8081.model.AvoidanceStrategy;
import ch.bfh.btx8081.model.Entry;
import ch.bfh.btx8081.model.Patient;
import ch.bfh.btx8081.model.QuestionForConsultation;

public interface PatientInterface {

	List<Entry> getDiaryEntries(Patient patient);

	void createNewActivity(Patient patient, String activity, String iconID);

	void removeNewActivity(Patient patient, Activity activity);

	void createNewAvoidanceStrategy(Patient patient, String avoidanceStrategy);

	void removeNewAvoidanceStrategy(Patient patient, AvoidanceStrategy avoidanceStrategy);

	void newEntry(LocalDate date, Patient patient, long consumption, int pressureToConsume, int motivation,
			List<Activity> activities, String comment, String questionForConsultation)
			throws ShowAvoidanceStrategyException;

	void createNewQuestionForConsultation(Patient patient, String questionForConsultation);

	void removeNewQuestionForConsultation(Patient patient, QuestionForConsultation questionForConsultation);

	AvoidanceStrategy getRandomAvoidanceStrategy(Patient patient);

	void sendUrgentCaseAlarm(Patient patient, String message);

	void sendAppontmentAlarm(Patient patient, String message);

}
