package ch.bfh.btx8081.gui.doctor;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.model.Alarm;
import ch.bfh.btx8081.model.Patient;

@Route(value = "main-doctor")
public class MainDoctorView extends VerticalLayout implements MainDoctorInterface {

	/**
	 * Idea: MainDoctorView: showing all patients and alarms of logged doctor;
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static final String TITLE = "SearchByNameView";

	private MainDoctorListener presenter;

	private Grid<Patient> patientList = new Grid<>(Patient.class);
	
	
	
	private TextField filterText = new TextField();
	private HorizontalLayout hLayout = new HorizontalLayout();

	// just a place holder for alarms; will be changed after alarm is implemented
	private Grid<Alarm> alarms = new Grid<>(Alarm.class);

	public MainDoctorView() {
		
		Button LogOutButton = new Button("Log out", event -> {
			presenter.hadleLogOutClick();
		});
		
		Button createPatientButton = new Button("create new patient", event -> {
			presenter.hadleCreateNewPatientClick();
		});

		filterText.setPlaceholder("Filter by name...");
		filterText.setClearButtonVisible(true);
		filterText.setValueChangeMode(ValueChangeMode.EAGER);
		filterText.addValueChangeListener(e -> presenter.hadleSearchPatientClick(filterText.getValue()));

		patientList.setColumns("firstName", "lastName");
		patientList.addSelectionListener(event -> {
			this.presenter.hadleOpenPatientClick((Patient) patientList.getSelectedItems().toArray()[0]);
		});

		hLayout.add(filterText, createPatientButton, LogOutButton);
		add(hLayout, patientList, alarms);
	}

	@Override
	public void setPatientList(List<Patient> list) {
		patientList.setItems(list);
	}

	@Override
	public void setAlarms(ArrayList<Alarm> alarms) {
		this.alarms.setItems(alarms);

	}

	@Override
	public void addListener(MainDoctorListener presenter) {
		this.presenter = presenter;
	}
}
