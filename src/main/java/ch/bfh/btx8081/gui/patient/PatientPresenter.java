package ch.bfh.btx8081.gui.patient;

import java.util.Optional;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import ch.bfh.btx8081.interfaces.PatientService;

public class PatientPresenter {
	
	private PatientService service;
	private Optional<UI> gui;
	private VerticalLayout view;
	
	public PatientPresenter(PatientService service, Optional<UI> gui) {
		this.service = service;
		this.gui = gui;
		showMainPatientView();
	}
	
	
	private void showMainPatientView() {
		MainPatientView mainPatientView = new MainPatientView();
		gui.ifPresent(ui -> ui.navigate(mainPatientView.getClass()));
		mainPatientView.setPresenter(this);
		mainPatientView.setPatientFName(service.getPatient().getFirstName());
		mainPatientView.setPatientLName(service.getPatient().getLastName());
		mainPatientView.setDoctorLbl(service.getPatient().getDoctor().getFirstName() + " " + service.getPatient().getDoctor().getLastName());
		mainPatientView.setAddictionLbl(service.getPatient().getAddiction());
		mainPatientView.setEntriesNumberLbl(service.getPatient().getDiary().getEntries().size() + "");
	}
	
	
}
