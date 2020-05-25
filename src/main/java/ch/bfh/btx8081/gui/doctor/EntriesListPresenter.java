package ch.bfh.btx8081.gui.doctor;

import ch.bfh.btx8081.gui.shared.MainView;
import ch.bfh.btx8081.interfaces.PatientService;

public class EntriesListPresenter implements EntriesListInterface.EntriesListListener {
	
	private EntriesListView view;
	private PatientService service;
	private MainView main;
	
	public EntriesListPresenter(EntriesListView view, PatientService service, MainView main) {
		this.view = view;
		this.service = service;
		this.main = main;
		view.addListener(this);
	}

	@Override
	public void hadleOpenEntryClick() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hadleBackClick() {
		// TODO Auto-generated method stub
		
	}
	
}
