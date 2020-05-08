package ch.bfh.btx8081.gui.patient;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;

public class PressureView  extends VerticalLayout implements PatientViewInterface{
	
	/**
	 * Shows View where patient can enter felt pressure to consume 
	 * on a scale from 1 to 10
	 */
	private static final long serialVersionUID = 1114308463028569154L;
	public static final String VIEW_NAME = "Pressure";
	
	private ViewListenerInterface presenter;
	
	private NumberField  pressureLevel;
	private Label pressureLbl;
	private Button nextBtn;
	
	public PressureView(NewEntryView baseView) {
		
		presenter = new Presenter();
		
		// Label with instruction
		pressureLbl = new Label("Enter your consumtion pressure on a scale from 1 to 10");
		this.add(pressureLbl);
		
		// NumberField
		pressureLevel = new NumberField ();
		pressureLevel.setValue(1d);
		pressureLevel.setHasControls(true);
		pressureLevel.setMin(1);
		pressureLevel.setMax(10);
		this.add(pressureLevel);
				
		
		// Next Button
		nextBtn = new Button("Next");
		nextBtn.addClickListener(e -> baseView.setView(baseView.getConsumptionView()));
		presenter.nextBtnClicked(this.VIEW_NAME, getPressureIndex() );
		this.add(nextBtn);	
		
	}
	
	@Override
	public void addListener(ViewListenerInterface listener) {
		this.presenter = listener;	
	}
	
	
	public double getPressureIndex() {
		return pressureLevel.getValue();
	}
	
	
	
}
