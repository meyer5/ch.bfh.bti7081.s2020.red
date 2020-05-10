package ch.bfh.btx8081.gui.patient;

import java.time.LocalDate;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class StartView  extends VerticalLayout implements PatientViewInterface {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3944803548180188360L;

	public static final String VIEW_NAME = "Start";

	private Presenter presenter;
	private EntryViewController viewController;
	
	private Label title;
	private Button nextBtn;
	private DatePicker readonlyDatePicker;

	public StartView(Presenter presenter, EntryViewController viewController) {
		
		this.presenter = presenter;
		this.viewController = viewController;
		
		this.title = new Label("Start your diary entry");
		add(title);
		// Show date for entry
		this.readonlyDatePicker = new DatePicker();
		readonlyDatePicker.setLabel("Read-only");
		readonlyDatePicker.setValue(LocalDate.now());
		readonlyDatePicker.setReadOnly(true);
		add(readonlyDatePicker);
		
		this.nextBtn = new Button("Start");
		nextBtn.addClickListener(e -> handleNextBtn());
		add(nextBtn);
	}
	
	/* TODO
	public void checkButtonVisibility() {
		
		// disable Start button if today's entry already made
		System.out.println(presenter.isConfirmed());
		if (presenter.isConfirmed()==true) {
			nextBtn.setVisible(false);
		}
	}
	*/

	private LocalDate getEntryDate() {
		return readonlyDatePicker.getValue();
	}

	@Override
	public void handleNextBtn() {
		this.viewController.setView();
		presenter.nextBtnClicked(ActivityView.VIEW_NAME, getEntryDate());
	}

	@Override
	public String getName() {
		return StartView.VIEW_NAME;
	}
	
}
