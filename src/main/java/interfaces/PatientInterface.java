package interfaces;

import java.util.ArrayList;

import exceptions.ShowAvoidanceStrategyException;
import exceptions.UserNotFoundException;
import exceptions.WrongPasswordException;
import model.Activity;
import model.AvoidanceStrategy;
import model.Entry;
import model.Patient;
import model.QuestionForConsultation;

public interface PatientInterface {

	ArrayList<Entry> getDiaryEntries(Patient patient);

	void authenticate(String userName, String password) throws WrongPasswordException, UserNotFoundException;
	
	void createNewActivity(Patient patient, String activity, String iconID);

	void removeNewActivity(Patient patient, Activity activity);

	void createNewAvoidanceStrategy(Patient patient, String avoidanceStrategy);

	void removeNewAvoidanceStrategy(Patient patient, AvoidanceStrategy avoidanceStrategy);
	
	void newEntry(Patient patient, int mood, long consumption, int pressureToConsume, int motivation,
			ArrayList<Activity> activities, String comment, QuestionForConsultation questionForConsultation)
			throws ShowAvoidanceStrategyException;
	
}
