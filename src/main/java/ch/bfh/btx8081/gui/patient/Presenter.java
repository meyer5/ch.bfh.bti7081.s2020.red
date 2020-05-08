package ch.bfh.btx8081.gui.patient;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Presenter implements ViewListenerInterface{

	List<PatientViewInterface> patientViews;
	BigDecimal consumption;
	double motivation;
	String comment;
	double pressure;
	
	
	//TODO Input validation
	// Fragen -> leerer String oder NULL
	
	public Presenter() {
		super();
		this.patientViews = new ArrayList<PatientViewInterface>();
		this.consumption = new BigDecimal(0);
		this.motivation = 0.0;
//		this.comment;
		this.pressure = 0.0;
	}

	@Override
	public List<PatientViewInterface> addView(PatientViewInterface view) {
		patientViews.add(view);
		return null;
	}

	@Override
	public void nextBtnClicked(String viewName, double number) {
				
		if(viewName.equals("Pressure")) {
			this.pressure = number;
		}
		if(viewName.equals("Motivation")) {
			this.motivation = number;
		}
	}

	@Override
	public void nextBtnClicked(String viewName, BigDecimal consumption) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void nextBtnClicked(String viewName, String comment) {
		// TODO Auto-generated method stub
		
	}

	

	

	
	
	
	
}
