package ch.bfh.btx8081.gui.shared;

import ch.bfh.btx8081.model.Patient;
import ch.bfh.btx8081.model.QuestionForConsultation;

public interface QuestionsInterface {

	public void setPatient(Patient patient);

	public void addListener(QuestionsListener presenter);

	public interface QuestionsListener {

		public void hadleBackClick();

		public void hadleQuestionDoneClick(QuestionForConsultation question);

		public void hadleCreateQuestionClick(String question);

	}

}
