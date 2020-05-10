package ch.bfh.btx8081.gui.patient;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ActivityView extends VerticalLayout implements PatientViewInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6591395272625160181L;

	public static final String VIEW_NAME = "Activity";

	private Presenter presenter;
	private EntryViewController viewController;
	
	private Label title;
	
	private Button nextBtn;

	public ActivityView(Presenter presenter, EntryViewController viewController) {

		this.presenter = presenter;
		this.viewController = viewController;
		
		this.title = new Label("What did you do today?");
		this.add(title);
		
		// Next Button
		nextBtn = new Button("Next");
		// go to next view
		nextBtn.addClickListener(e -> handleNextBtn());
		// pass value to listener

		this.add(nextBtn);

	}
	
	
	
	@Override
	public String getName() {
		return ActivityView.VIEW_NAME;
	}


	@Override
	public void handleNextBtn() {
		this.viewController.setView();
//		presenter.nextBtnClicked(ActivityView.VIEW_NAME, getMotivationIndex());
	}

}
