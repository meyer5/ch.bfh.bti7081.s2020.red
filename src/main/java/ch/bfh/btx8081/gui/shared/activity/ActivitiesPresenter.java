package ch.bfh.btx8081.gui.shared.activity;

import ch.bfh.btx8081.gui.shared.main.MainView;
import ch.bfh.btx8081.interfaces.DoctorService;
import ch.bfh.btx8081.interfaces.PatientService;
import ch.bfh.btx8081.interfaces.Service;
import ch.bfh.btx8081.model.Activity;

public class ActivitiesPresenter implements ActivitiesInterface.ActivitiesListener {
	
	private ActivitiesView view;
	private Service service;
	private MainView main;
	
	public ActivitiesPresenter(ActivitiesView view, Service service, MainView main) {
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
	public void hadleDeleteActivityClick(Activity activity) {
		service.removeNewActivity(activity);
		view.setPatient(service.getPatient());
		
	}

	@Override
	public void hadleSaveClick(String activity, String iconID) {
		service.createNewActivity(activity, iconID);
		view.setPatient(service.getPatient());
	}



}
