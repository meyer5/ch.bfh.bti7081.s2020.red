package ch.bfh.btx8081.gui.doctor;

import ch.bfh.btx8081.gui.shared.MainView;
import ch.bfh.btx8081.interfaces.DoctorService;
import ch.bfh.btx8081.interfaces.PatientService;

public class EditPatientPresenter implements EditPatientInterface.EditPatientListener {

	private EditPatientView view;
	private DoctorService service;
	private MainView main;

	public EditPatientPresenter(EditPatientView view, DoctorService service, MainView main) {
		this.view = view;
		this.service = service;
		this.main = main;
		view.addListener(this);
	}

	@Override
	public void hadleSaveClick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hadleBackClick() {
		// TODO Auto-generated method stub
		
	}
}
