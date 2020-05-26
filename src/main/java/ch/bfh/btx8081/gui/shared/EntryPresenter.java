package ch.bfh.btx8081.gui.shared;

import ch.bfh.btx8081.interfaces.DoctorService;
import ch.bfh.btx8081.interfaces.PatientService;
import ch.bfh.btx8081.interfaces.Service;
import ch.bfh.btx8081.model.Entry;

public class EntryPresenter implements EntryInterface.EntryListener {
	
	private EntryView view;
	private Service service;
	private MainView main;
	
	public EntryPresenter(EntryView view, Service service, MainView main, Entry entry) {
		this.view = view;
		this.service = service;
		this.main = main;
		view.addListener(this);
		view.setEntry(entry);
	}

	@Override
	public void hadleBackClick() {
		if (service instanceof DoctorService) {
			main.openMainDoctorView((DoctorService) service);
		} else if (service instanceof PatientService) {
			main.openMainPatientView((PatientService) service);
		}
	}

}
