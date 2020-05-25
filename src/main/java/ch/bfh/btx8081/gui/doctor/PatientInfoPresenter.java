package ch.bfh.btx8081.gui.doctor;

import ch.bfh.btx8081.gui.shared.MainView;
import ch.bfh.btx8081.interfaces.PatientService;

public class PatientInfoPresenter implements PatientInfoInterface.PatientInfoListener {
	
	private PatientInfoView view;
	private PatientService service;
	private MainView main;
	
	public PatientInfoPresenter(PatientInfoView view, PatientService service, MainView main) {
		this.view = view;
		this.service = service;
		this.main = main;
		view.addListener(this);
	}

	@Override
	public void hadleActivitiesClick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hadleStrategiesClick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hadleQuestionsClick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hadleOpenEntryClick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hadleEntriesListClick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hadleBackClick() {
		// TODO Auto-generated method stub
		
	}

}
