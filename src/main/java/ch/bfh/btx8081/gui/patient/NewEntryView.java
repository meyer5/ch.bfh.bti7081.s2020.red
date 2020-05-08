package ch.bfh.btx8081.gui.patient;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "entry")
public class NewEntryView extends VerticalLayout implements PatientViewInterface {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8444035923377022134L;
	public static final String VIEW_NAME = "New Entry";
	
	
	//Views
	private Component pressureView;
	private Component motivationView;
	private Component consumptionView;
	private Component activityView;
	private Component commentView;
	
	
	private ViewListenerInterface presenter;
	
	public NewEntryView() {
		presenter = new Presenter();
		
		// initialise views
		pressureView = new PressureView(this);
		motivationView = new MotivationView(this);
		consumptionView = new ConsumptionView(this);
//		activityView = new ActivityView(this);
		commentView = new CommentView(this);
		
		// Initial view
		setView(pressureView);
					
	}
	
	
	
	public void setView(Component newView) {
		this.removeAll();
		this.add(newView);
		
	}



	@Override
	public void addListener(ViewListenerInterface listener) {
		this.presenter = listener;
		
	}



	public Component getPressureView() {
		return pressureView;
	}



	public Component getMotivationView() {
		return motivationView;
	}



	public Component getConsumptionView() {
		return consumptionView;
	}



	public Component getActivityView() {
		return activityView;
	}



	public Component getCommentView() {
		return commentView;
	}


	
	
	
}
