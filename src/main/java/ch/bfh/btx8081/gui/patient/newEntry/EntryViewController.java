package ch.bfh.btx8081.gui.patient.newEntry;

import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.interfaces.PatientService;

/**
 * This class is responsible for the navigation between the 
 * different entry views
 * 
 * @author Remo
 */

@Route(value = "entry-new")
public class EntryViewController extends VerticalLayout{
	
	private static final long serialVersionUID = 6093477111794627722L;

	public static final String VIEW_NAME = "Diary Entry";
	
	private Component title;
	
	private NewEntryPresenter patientPresenter;
		
	// Views
	private Component startView;
	private Component motivationView;
	private Component pressureView;
	private Component consumptionView;
	private Component activityView;
	private Component commentView;
	private Component questionView;
	private Component confirmView;
	
	private PatientViewInterface currentView;
	private PatientService patientService;

	public EntryViewController() {
		
		this.title = new Label("Diary Entry");
		add(title);		
		
		this.patientPresenter = new NewEntryPresenter(patientService);
		
		// initialise views
		this.startView = new StartView(patientPresenter, this);
		this.pressureView = new PressureView(patientPresenter, this);
		this.motivationView = new MotivationView(patientPresenter, this);
		this.consumptionView = new ConsumptionView(patientPresenter, this);
		this.activityView = new ActivityView(patientPresenter, this);
		this.commentView = new CommentView(patientPresenter, this);
		this.questionView = new QuestionView(patientPresenter, this);
		this.confirmView = new ConfirmView(patientPresenter, this);
		
		setCurrentView(startView);
		// Add initial view
		add(startView);
	}


	//View nach confirm view ????
	public Component getNextView() {
		String viewName = currentView.getName();
		System.out.println(viewName);
		Component nextView = startView;
		
		switch (viewName) {
		case StartView.VIEW_NAME:
			nextView = motivationView;
			break;
		case MotivationView.VIEW_NAME:
			nextView = pressureView;
			break;
		case PressureView.VIEW_NAME:
			nextView = consumptionView;
			break;
		case ConsumptionView.VIEW_NAME:
			nextView = activityView;
			break;
		case ActivityView.VIEW_NAME:
			nextView = commentView;
			break;
		case CommentView.VIEW_NAME:
			nextView = questionView;
			break;
		case QuestionView.VIEW_NAME:
			nextView = confirmView;
			break;
		case ConfirmView.VIEW_NAME:
			nextView = startView;
			break;
		default:
			nextView = startView;
		}
//		System.out.println(nextView.getClass());	// to check for correct class
		setCurrentView(nextView);
		return nextView;
	}
	
	
	public void setView() {
		removeAll();
		Component nextView = getNextView();
		this.add(title, nextView);
	}
	
	public void setCurrentView(Component nextView) {
		this.currentView = (PatientViewInterface) nextView;
	}

	public Component getCurrentView() {
		return (Component) currentView;
	}

	public Component getStartView() {
		return startView;
	}

	public NewEntryPresenter getPresenter() {
		return patientPresenter;
	}


	
	
}
