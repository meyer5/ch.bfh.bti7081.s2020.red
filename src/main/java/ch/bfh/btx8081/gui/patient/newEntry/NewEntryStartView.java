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
public class NewEntryStartView extends VerticalLayout implements NewEntryInterface {

	private static final long serialVersionUID = 1L;

	private NewEntryListener presenter;

	private Label title;
	private Button startBtn;
	private DatePicker readonlyDatePicker;

	public NewEntryStartView() {

		this.title = new Label("Start your diary entry");
		add(title);
		// Show date for entry
		this.readonlyDatePicker = new DatePicker();
		readonlyDatePicker.setLabel("What day are you talking about?");
		readonlyDatePicker.setValue(LocalDate.now());
//		readonlyDatePicker.setReadOnly(true);
		add(readonlyDatePicker);

		// initialize start button
		this.startBtn = new Button("Start");
		startBtn.addClickListener(e -> {
			presenter.handleConfirmDate(readonlyDatePicker.getValue());
		});
		add(startBtn);

	}

	// TODO button should be disabled --> How????
//	private void checkVisibilityStartButton() {
//
//		// disable Start button if today's entry already made
//		System.out.println(patientPresenter.isConfirmed());
//		if (patientPresenter.isConfirmed() == true) {
//			System.out.println("Button invisible");
//			startBtn.setVisible(false);
//		} else {
//			startBtn.setVisible(true);
//			System.out.println("Button visible");
//		}
//	}

	@Override
	public void setListener(NewEntryListener presenter) {
		this.presenter = presenter;

	}

}
