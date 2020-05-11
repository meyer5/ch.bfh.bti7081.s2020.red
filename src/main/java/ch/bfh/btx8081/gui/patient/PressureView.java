package ch.bfh.btx8081.gui.patient;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;


/**
 * View where patient can enter felt pressure to consume 
 * on a given scale
 * 
 * @author Remo
 *
 */
public class PressureView  extends VerticalLayout implements PatientViewInterface{
	
	private static final long serialVersionUID = 1114308463028569154L;
	public static final String VIEW_NAME = "Pressure";
	
	private Presenter presenter;
	private EntryViewController viewController;
	
	private Label title;
	private NumberField  pressureLevel;
	private Label pressureLbl;
	private Button nextBtn;
	
	public PressureView(Presenter presenter, EntryViewController viewController) {
		
		this.presenter = presenter;
		this.viewController = viewController;
		
		// Label with title
		this.title = new Label("Pressure");
		add(title);
		// Label with instruction
		pressureLbl = new Label("Enter your consumtion pressure on a scale from 1 to 10");
		add(pressureLbl);
		
		// NumberField
		pressureLevel = new NumberField ();
		pressureLevel.setValue(1d);
		pressureLevel.setHasControls(true);
		pressureLevel.setMin(1);
		pressureLevel.setMax(10);
		this.add(pressureLevel);
				
		
		// Next Button
		nextBtn = new Button("Next");
		nextBtn.addClickListener(e -> handleNextBtn());
		this.add(nextBtn);	
		
	}
	
	
	public double getPressureIndex() {
		return pressureLevel.getValue();
	}


	@Override
	public String getName() {
		return PressureView.VIEW_NAME;
	}


	@Override
	public void handleNextBtn() {
		this.viewController.setView();
		presenter.nextBtnClicked(PressureView.VIEW_NAME, getPressureIndex() );
	}
	
	
	
}
