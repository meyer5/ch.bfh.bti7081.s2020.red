package ch.bfh.btx8081.gui.shared;

import ch.bfh.btx8081.interfaces.DoctorService;
import ch.bfh.btx8081.interfaces.PatientService;
import ch.bfh.btx8081.interfaces.Service;
import ch.bfh.btx8081.model.QuestionForConsultation;

public class QuestionsPresenter implements QuestionsInterface.QuestionsListener {

	private QuestionsView view;
	private Service service;
	private MainView main;
	
	public QuestionsPresenter(QuestionsView view, Service service, MainView main) {
		this.view = view;
		this.service = service;
		this.main = main;
		view.addListener(this);
		view.setPatient(service.getPatient());
	}

	@Override
	public void hadleBackClick() {
		if (service instanceof DoctorService) {
			main.openPatientInfoView((DoctorService) service);
		} else if (service instanceof PatientService) {
			main.openMainPatientView((PatientService) service);
		}
	}

	@Override
	public void hadleQuestionDoneClick(QuestionForConsultation questionForConsultation) {
		service.removeNewQuestionForConsultation(questionForConsultation);
		view.setPatient(service.getPatient());
	}

	@Override
	public void hadleCreateQuestionClick(String questionForConsultation) {
		service.createNewQuestionForConsultation(questionForConsultation);
		view.setPatient(service.getPatient());
	}
	
}
