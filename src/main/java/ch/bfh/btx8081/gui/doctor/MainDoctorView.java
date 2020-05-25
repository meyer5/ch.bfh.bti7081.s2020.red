package ch.bfh.btx8081.gui.doctor;

import java.util.ArrayList;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.model.Patient;

@Route(value = "main-doctor")
public class MainDoctorView extends VerticalLayout implements MainDoctorInterface {

	/**
	 * Idea: MainDoctorView: showing all patients and alarms of logged doctor;
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String TITLE = "SearchByNameView";

	private ArrayList<MainDoctorListener> listeners = new ArrayList<MainDoctorListener>();

	private Grid<Patient> patientList = new Grid<>(Patient.class);
	private SplitLayout layout = new SplitLayout();
	private TextField filterText = new TextField();
	private Button createPatientButton = new Button("create new patient");

	// just a place holder for alarms; will be changed after alarm is implemented
	private VerticalLayout alarms = new VerticalLayout();
	private Checkbox alarm = new Checkbox("Alarm1");
	private Checkbox alarm2 = new Checkbox("Alarm2");
	private Checkbox alarm3 = new Checkbox("Alarm3");
	private Checkbox alarm4 = new Checkbox("Alarm4");

	public MainDoctorView() {

		filterText.setPlaceholder("Filter by name...");
		filterText.setClearButtonVisible(true);
		filterText.setValueChangeMode(ValueChangeMode.EAGER);
		filterText.addValueChangeListener(e -> updateList());

		patientList.setColumns("id", "firstName", "lastName");

		alarms.add(alarm, alarm2, alarm3, alarm4);

		layout.addToPrimary(createPatientButton);
		layout.addToSecondary(alarms);

		add(filterText, patientList, layout);

		updateList();
	}

	public void updateList() {
		// grid.setItems(service.findAll(filterText.getValue()));
	}

	@Override
	public void setDoctor() {
		// TODO Auto-generated method stub

	}

	@Override
	public void addListener(MainDoctorListener presenter) {
		listeners.add(presenter);
	}
}
