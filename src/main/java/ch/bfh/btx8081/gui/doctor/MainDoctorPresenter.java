package ch.bfh.btx8081.gui.doctor;

import ch.bfh.btx8081.gui.shared.MainView;
import ch.bfh.btx8081.interfaces.DoctorService;

public class MainDoctorPresenter implements MainDoctorInterface.MainDoctorListener {
	
	private MainDoctorView view;
	DoctorService service;
	private MainView main;
	
	public MainDoctorPresenter(MainDoctorView view, DoctorService service, MainView main) {
		this.view = view;
		this.service = service;
		this.main = main;
		view.addListener(this);
	}

	@Override
	public void hadleCreateNewPatientClick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hadleOpenPatientClick() {
		// TODO Auto-generated method stub
		
	}
	
	

}
