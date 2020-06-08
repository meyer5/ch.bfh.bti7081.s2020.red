package ch.bfh.btx8081.gui.doctor.createPatient;

import ch.bfh.btx8081.exceptions.UsernameIsAlreadyTakenException;
import ch.bfh.btx8081.gui.shared.main.MainView;
import ch.bfh.btx8081.interfaces.DoctorService;

public class CreatePatientPresenter implements CreatePatientInterface.CreatePatientListener {

	private CreatePatientView view;
	private DoctorService service;
	private MainView main;

	public CreatePatientPresenter(CreatePatientView view, DoctorService service, MainView main) {
		this.view = view;
		this.service = service;
		this.main = main;
		view.addListener(this);
	}

	@Override
	public void handleSaveClick(String firstName, String lastName, String phoneNumber, String eMail, String userName,
			String password, String addiction, String mainInfo, String consumedSubstance, String consumptionMetric,
			String conditionAutomaticAlarm) {
		if (firstName.isEmpty() || lastName.isEmpty() || phoneNumber.isEmpty() || eMail.isEmpty() || userName.isEmpty()
				|| password.isEmpty() || addiction.isEmpty() || consumedSubstance.isEmpty()
				|| consumptionMetric.isEmpty() || conditionAutomaticAlarm.isEmpty()) {
			view.fillAllFields();
		} else {
			try {
				service.newPatient(firstName, lastName, phoneNumber, eMail, userName, password, addiction, mainInfo,
						consumedSubstance, consumptionMetric, conditionAutomaticAlarm);
				main.openMainDoctorView(service);
			} catch (UsernameIsAlreadyTakenException e) {
				view.userNameAlreadyTaken();
			}
		}
	}

	@Override
	public void hadleCancelClick() {
		main.openMainDoctorView(service);
	}

}
