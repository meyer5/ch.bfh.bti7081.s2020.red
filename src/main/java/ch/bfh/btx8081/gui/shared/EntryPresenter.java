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
		this.view.addListener(this);
		this.view.setEntry(entry);
	}

	@Override
	public void hadleBackToMainClick() {
		if (service instanceof DoctorService) {
			main.openPatientInfoView((DoctorService) service);
		} else if (service instanceof PatientService) {
			main.openMainPatientView((PatientService) service);
		}
	}
	
	public void hadleBackToListClick() {
		main.openEntriesListView(service);
	}

}
