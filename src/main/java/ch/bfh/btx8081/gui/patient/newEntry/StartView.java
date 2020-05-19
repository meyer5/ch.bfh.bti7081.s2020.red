package ch.bfh.btx8081.gui.patient.newEntry;

import java.time.LocalDate;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * First view of the entry process
 * 
 * @author Remo
 */

@Route(value = "entry-start")
public class StartView extends VerticalLayout implements PatientViewInterface {

	private static final long serialVersionUID = -3944803548180188360L;

	public static final String VIEW_NAME = "Start";

	private NewEntryPresenter patientPresenter;
	private EntryViewController viewController;

	private Label title;
	private Button startBtn;
	private DatePicker readonlyDatePicker;

	public StartView(NewEntryPresenter patientPresenter, EntryViewController viewController) {

		this.patientPresenter = patientPresenter;
		this.viewController = viewController;

		this.title = new Label("Start your diary entry");
		add(title);
		// Show date for entry
		this.readonlyDatePicker = new DatePicker();
		readonlyDatePicker.setLabel("Read-only");
		readonlyDatePicker.setValue(LocalDate.now());
		readonlyDatePicker.setReadOnly(true);
		add(readonlyDatePicker);

		// initialize start button
		this.startBtn = new Button("Start");
		startBtn.addClickListener(e -> handleNextBtn());
		add(startBtn);

	}

	// TODO button should be disabled --> How????
	private void checkVisibilityStartButton() {

		// disable Start button if today's entry already made
		System.out.println(patientPresenter.isConfirmed());
		if (patientPresenter.isConfirmed() == true) {
			System.out.println("Button invisible");
			startBtn.setVisible(false);
		} else {
			startBtn.setVisible(true);
			System.out.println("Button visible");
		}
	}

	private LocalDate getEntryDate() {
		return readonlyDatePicker.getValue();
	}

	@Override
	public void handleNextBtn() {
		this.viewController.setView();
		patientPresenter.startBtnClicked(ActivityView.VIEW_NAME, getEntryDate());
	}

	@Override
	public String getName() {
		return StartView.VIEW_NAME;
	}

}
