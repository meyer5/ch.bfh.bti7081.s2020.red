package ch.bfh.btx8081.gui.doctor;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.UI;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.exceptions.UserNotFoundException;
import ch.bfh.btx8081.exceptions.WrongPasswordException;
import ch.bfh.btx8081.interfaces.DoctorService;
import ch.bfh.btx8081.interfaces.ServiceManager;

import ch.bfh.btx8081.model.DiaryManager;
import ch.bfh.btx8081.model.Patient;
import ch.bfh.btx8081.persistence.PersistenceManager;

@Route(value = "patient-info")
public class PatientInfoView extends HorizontalLayout implements PatientInfoInterface {

	private static final long serialVersionUID = 3407757504015724766L;
	public static final String TITLE = "Patient Info";

	private ArrayList<PatientInfoListener> listeners = new ArrayList<PatientInfoListener>();

	private List<Patient> patients = null;
	Patient patient = null;

	private final VerticalLayout layout;
	private DoctorService service = null;
	private PersistenceManager persistenceManager = null;

	public PatientInfoView() throws WrongPasswordException, UserNotFoundException {

		this.patient = new Patient();
		this.persistenceManager = new PersistenceManager();
		this.patients = persistenceManager.getPatients();

		final EditPatientView patientShowLayout = new EditPatientView();
		layout = new VerticalLayout();

		for (Patient p : patients) {
			System.out.println(p.getUserName());
			if (p.getUserName().equals("natalya")) {
				this.patient = p;
			}
		}

		patientShowLayout.setFirstName(patient.getFirstName());
		patientShowLayout.setLastName(patient.getLastName());
		patientShowLayout.setPhoneNumber(patient.getPhoneNumber());
		patientShowLayout.setEMail(patient.geteMail());
		patientShowLayout.setDoctor(patient.getDoctor().getFirstName());

		// Build a footer, add Save and Cancel buttons
		final HorizontalLayout footer = new HorizontalLayout();

		// Browser page is updated
		Button buttonCancel = new Button("Cancel");
		buttonCancel.addClickListener(event -> UI.getCurrent().getPage().reload());

		// Changed fields will be saved and browser page is updated
		Button buttonEdit = new Button("Edit", event -> {
			try {
				service.changeMainInfo(patientShowLayout.getMainInfo().getValue());

				service.changeContactInfo(patientShowLayout.getFirstName().getValue(),
						patientShowLayout.getLastName().getValue(), patientShowLayout.getPhoneNumber().getValue(),
						patientShowLayout.getEMail().getValue());

				service.setConditionAutomaticAlarm(patientShowLayout.getConditionAutomaticAlarm().getValue());

				System.out.println(patientShowLayout.getMainInfo().getValue());
				System.out.println(patientShowLayout.getFirstName().getValue());

				UI.getCurrent().getPage().reload();

			} catch (final Exception e) {
				e.printStackTrace();
			}
		});

		footer.getThemeList().set("spacing", true);
		footer.add(buttonEdit, buttonCancel);
		layout.add(patientShowLayout, footer);
		add(layout);
		expand(layout);
	}

	@Override
	public void setPatient() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addListener(PatientInfoListener presenter) {
		listeners.add(presenter);

	}
}
