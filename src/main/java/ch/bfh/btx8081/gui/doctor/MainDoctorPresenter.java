package ch.bfh.btx8081.gui.doctor;

import java.util.ArrayList;

import ch.bfh.btx8081.exceptions.PatientNotFoundException;
import ch.bfh.btx8081.gui.shared.MainView;
import ch.bfh.btx8081.interfaces.DoctorService;
import ch.bfh.btx8081.model.Patient;

public class MainDoctorPresenter implements MainDoctorInterface.MainDoctorListener {

	private MainDoctorView view;
	DoctorService service;
	private MainView main;

	public MainDoctorPresenter(MainDoctorView view, DoctorService service, MainView main) {
		this.view = view;
		this.service = service;
		this.main = main;
		view.addListener(this);
		view.setPatientList(service.getAllPatientsOfDoctor());
	}

	@Override
	public void hadleCreateNewPatientClick() {
		main.openCreatePatientView(service);
	}

	@Override
	public void hadleOpenPatientClick(Patient patient) {
		service.selectPatient(patient);
		main.openPatientInfoView(service);
	}

	@Override
	public void hadleSearchPatientClick(String search) {
		ArrayList<Patient> patients = new ArrayList<Patient>();
		try {
			patients.addAll(service.searchPatientOfDoctor(search));
		} catch (PatientNotFoundException e) {
		}
		view.setPatientList(patients);
	}

	@Override
	public void hadleLogOutClick() {
		main.openLoginView();
	}

}
