package ch.bfh.btx8081.gui.doctor;

import ch.bfh.btx8081.gui.shared.MainView;
import ch.bfh.btx8081.interfaces.PatientService;

public class CreatePatientPresenter implements CreatePatientInterface.CreatePatientListener {
	
	private CreatePatientView view;
	private PatientService service;
	private MainView main;

	public CreatePatientPresenter(CreatePatientView view, PatientService service, MainView main) {
		this.view = view;
		this.service = service;
		this.main = main;
		view.addListener(this);
	}

	@Override
	public void handleSaveClick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hadleCancelClick() {
		// TODO Auto-generated method stub
		
	}

}
