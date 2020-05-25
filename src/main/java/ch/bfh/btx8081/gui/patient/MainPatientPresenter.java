package ch.bfh.btx8081.gui.patient;

import ch.bfh.btx8081.gui.shared.MainView;
import ch.bfh.btx8081.interfaces.PatientService;

public class MainPatientPresenter implements MainPatientInterface.MainPatientListener {

	private MainPatientView view;
	private PatientService service;
	private MainView main;

	public MainPatientPresenter(MainPatientView view, PatientService service, MainView main) {
		this.view = view;
		this.service = service;
		this.main = main;
		view.addListener(this);
	}

	@Override
	public void handleNewEntryClick() {
		// TODO Auto-generated method stub
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
	public void hadleOpenEntryClick() {
		main.openEntryView(service);
		
	}

	@Override
	public void hadleEntriesListClick() {
		main.openEntriesListView(service);
		
	}
	
	

}
