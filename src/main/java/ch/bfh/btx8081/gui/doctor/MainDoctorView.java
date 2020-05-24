package ch.bfh.btx8081.gui.doctor;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.value.ValueChangeMode;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.model.Patient;

@Route(value = "main-doctor")
public class MainDoctorView extends VerticalLayout {

	/**
	 * Idea: Based on the persistence should load over a presenter.class all saved
	 * patients here
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static final String TITLE = "SearchByNameView";

	private DoctorPresenter presenter;

	private Grid<Patient> grid = new Grid<>(Patient.class);
	private TextField filterText = new TextField();

	public MainDoctorView(DoctorPresenter presenter) {
		this.presenter = presenter;
		filterText.setPlaceholder("Filter by name...");
		filterText.setClearButtonVisible(true);
		filterText.setValueChangeMode(ValueChangeMode.EAGER);
		filterText.addValueChangeListener(e -> updateList());

		grid.setColumns("id", "firstName", "lastName");

		add(filterText, grid);

		setSizeFull();

		updateList();
	}

	public void updateList() {
//        grid.setItems(service.findAll(filterText.getValue()));
	}

}
