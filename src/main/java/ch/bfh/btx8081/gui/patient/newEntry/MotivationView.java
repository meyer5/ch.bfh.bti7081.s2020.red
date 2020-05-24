package ch.bfh.btx8081.gui.patient.newEntry;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.Route;

/**
 * View where patient enters his motivation on a given scale
 * 
 * @author Remo
 *
 */

@Route(value = "entry-motivation")
public class MotivationView extends VerticalLayout implements PatientViewInterface {

	
	private static final long serialVersionUID = -4974676408821678992L;

	public static final String VIEW_NAME = "Motivation";
	
	private NewEntryPresenter patientPresenter;
	private EntryViewController viewController;
	
	private Label title;
	private NumberField motivationLevel;
	private Label motivationLbl;
	private Button nextBtn;
	
	public MotivationView(NewEntryPresenter patientPresenter, EntryViewController viewController) {
		
		this.patientPresenter = patientPresenter;
		this.viewController = viewController;
		
		// Label with title
		this.title = new Label("Motivation");
		add(title);
		// Label with instruction
		this.motivationLbl = new Label("Enter your motivation on a scale from 1 to 10");
		add(motivationLbl);

		// NumberField
		motivationLevel = new NumberField();
		motivationLevel.setValue(1d);
		motivationLevel.setHasControls(true);
		motivationLevel.setMin(1);
		motivationLevel.setMax(10);
		add(motivationLevel);

		// Next Button
		nextBtn = new Button("Next");
		// go to next view
		nextBtn.addClickListener(e -> handleNextBtn());
		// pass value to listener 
		
		add(nextBtn);

	}

		
	public double getMotivationIndex() {
		return motivationLevel.getValue();
	}


	@Override
	public String getName() {
		return MotivationView.VIEW_NAME;
	}


	@Override
	public void handleNextBtn() {
		this.viewController.setView();
		this.patientPresenter.nextBtnClicked(MotivationView.VIEW_NAME, getMotivationIndex() );
		
	}

}
