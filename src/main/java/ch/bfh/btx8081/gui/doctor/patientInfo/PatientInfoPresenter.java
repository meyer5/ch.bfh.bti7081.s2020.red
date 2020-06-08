package ch.bfh.btx8081.gui.doctor.patientInfo;

import ch.bfh.btx8081.gui.shared.main.MainView;
import ch.bfh.btx8081.interfaces.DoctorService;
import ch.bfh.btx8081.model.Entry;

public class PatientInfoPresenter implements PatientInfoInterface.PatientInfoListener {
	
	private PatientInfoView view;
	private DoctorService service;
	private MainView main;
	
	public PatientInfoPresenter(PatientInfoView view, DoctorService service, MainView main) {
		this.view = view;
		this.service = service;
		this.main = main;
		this.view.addListener(this);
		this.view.setPatient(service.getPatient());
	}

	@Override
	public void hadleActivitiesClick() {
		main.openActivitiesView(service);
	}

	@Override
	public void hadleStrategiesClick() {
		main.openStrategiesView(service);
	}

	@Override
	public void hadleQuestionsClick() {
		main.openQuestionsView(service);
	}

	@Override
	public void hadleOpenEntryClick(Entry entry) {
		main.openEntryView(service, entry);
	}

	@Override
	public void hadleEntriesListClick() {
		main.openEntriesListView(service);
	}

	@Override
	public void hadleBackClick() {
		main.openMainDoctorView(service);
	}

	@Override
	public void hadleEditClick() {
		main.openEditPatientView(service);
	}

	@Override
	public void hadleLogOutClick() {
		main.openLoginView();
	}

	@Override
	public void hadleAutomaticAlarmClick() {
		main.openAutomaticAlarmView(service);
	}

}
