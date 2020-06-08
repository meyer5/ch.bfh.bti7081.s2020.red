package ch.bfh.btx8081.gui.doctor.editPatient;

import ch.bfh.btx8081.gui.shared.main.MainView;
import ch.bfh.btx8081.interfaces.DoctorService;

public class EditPatientPresenter implements EditPatientInterface.EditPatientListener {

	private EditPatientView view;
	private DoctorService service;
	private MainView main;

	public EditPatientPresenter(EditPatientView view, DoctorService service, MainView main) {
		this.view = view;
		this.service = service;
		this.main = main;
		view.addListener(this);
		view.setPatient(service.getPatient());
	}

	@Override
	public void handleSaveClick(String firstName, String lastName, String phoneNumber, String eMail,
			String newMainInfo) {
		if (firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty() || eMail.isEmpty()) {
			view.fillAllFields();
		} else {
			service.changeContactInfo(firstName, lastName, phoneNumber, eMail);
			service.changeMainInfo(newMainInfo);
			main.openPatientInfoView(service);
		}
	}

	@Override
	public void handleCancelClick() {
		main.openPatientInfoView(service);
	}
}
