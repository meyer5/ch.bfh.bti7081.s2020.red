package ch.bfh.btx8081.gui.patient;

import ch.bfh.btx8081.gui.shared.MainView;
import ch.bfh.btx8081.interfaces.PatientService;
import ch.bfh.btx8081.model.Entry;

public class MainPatientPresenter implements MainPatientInterface.MainPatientListener {

	private MainPatientView view;
	private PatientService service;
	private MainView main;

	public MainPatientPresenter(MainPatientView view, PatientService service, MainView main) {
		this.view = view;
		this.service = service;
		this.main = main;
		view.setPresenter(this);
		view.setPatient(service.getPatient());
	}

	@Override
	public void handleNewEntryClick() {
		main.openNewEntryView(service);
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
	public void hadleShowStrategyClick() {
		main.openShowStrategyView(service);
		
	}

	@Override
	public void hadleAlarmClick() {
		main.openAlarmView(service);
		
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
	public void hadleLogOutClick() {
		main.openLoginView();
	}
	
	

}
