package ch.bfh.btx8081.gui.patient;

import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;

public class MotivationView extends VerticalLayout implements PatientViewInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4974676408821678992L;

	public static final String VIEW_NAME = "Motivation";
	
	private Presenter presenter;
	private EntryViewController viewController;
	
	private NumberField motivationLevel;
	private Label motivationLbl;
	private Button nextBtn;

	public MotivationView(Presenter presenter, EntryViewController viewController) {
		
		this.presenter = presenter;
		this.viewController = viewController;
		// Label with instruction
		motivationLbl = new Label("Enter your motivation on a scale from 1 to 10");
		this.add(motivationLbl);

		// NumberField
		motivationLevel = new NumberField();
		motivationLevel.setValue(1d);
		motivationLevel.setHasControls(true);
		motivationLevel.setMin(1);
		motivationLevel.setMax(10);
		this.add(motivationLevel);

		// Next Button
		nextBtn = new Button("Next");
		// go to next view
		nextBtn.addClickListener(e -> handleNextBtn());
		// pass value to listener 
		
		this.add(nextBtn);

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
		this.presenter.nextBtnClicked(MotivationView.VIEW_NAME, getMotivationIndex() );
		
	}

}
