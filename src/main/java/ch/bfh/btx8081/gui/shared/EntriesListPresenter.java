package ch.bfh.btx8081.gui.shared;

import ch.bfh.btx8081.interfaces.DoctorService;
import ch.bfh.btx8081.interfaces.PatientService;
import ch.bfh.btx8081.interfaces.Service;
import ch.bfh.btx8081.model.Entry;

public class EntriesListPresenter implements EntriesListInterface.EntriesListListener {
	
	private EntriesListView view;
	private Service service;
	private MainView main;
	
	public EntriesListPresenter(EntriesListView view, Service service, MainView main) {
		this.view = view;
		this.service = service;
		this.main = main;
		this.view.addListener(this);
		this.view.setPatient(service.getPatient());
	}

	@Override
	public void hadleOpenEntryClick(Entry entry) {
		main.openEntryView(service, entry);
	}

	@Override
	public void hadleBackClick() {
		if (service instanceof DoctorService) {
			main.openPatientInfoView((DoctorService) service);
		} else if (service instanceof PatientService) {
			main.openMainPatientView((PatientService) service);
		}
	}
	
}
