package ch.bfh.btx8081.interfaces;

import java.util.List;

import ch.bfh.btx8081.model.Activity;
import ch.bfh.btx8081.model.AvoidanceStrategy;
import ch.bfh.btx8081.model.Entry;
import ch.bfh.btx8081.model.Patient;
import ch.bfh.btx8081.model.QuestionForConsultation;

public interface Service {
	
	public void createNewActivity(String activity, String iconID);

	public void removeNewActivity(Activity activity);

	public void createNewAvoidanceStrategy(String avoidanceStrategy);

	public void removeNewAvoidanceStrategy(AvoidanceStrategy avoidanceStrategy);
	
	public void createNewQuestionForConsultation(String questionForConsultation);

	public void removeNewQuestionForConsultation(QuestionForConsultation questionForConsultation);
	
	public List<Entry> getDiaryEntries();
	
	public Patient getPatient();

}
