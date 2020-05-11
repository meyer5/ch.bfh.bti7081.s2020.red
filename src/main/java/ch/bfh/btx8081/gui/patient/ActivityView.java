package ch.bfh.btx8081.gui.patient;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

/**
 * View where Patient can choose one or more activities he
 * performed in order to avoid consumption
 * 
 * @author Remo
 *
 */
public class ActivityView extends VerticalLayout implements PatientViewInterface {

	private static final long serialVersionUID = -6591395272625160181L;

	public static final String VIEW_NAME = "Activity";

	private Presenter presenter;
	private EntryViewController viewController;
	
	private Label title;
	private Label commentLbl;
	private Button nextBtn;

	public ActivityView(Presenter presenter, EntryViewController viewController) {

		this.presenter = presenter;
		this.viewController = viewController;
		
		this.title = new Label("Activities");
		add(title);
		
		this.commentLbl = new Label("What did you do today?");
		add(commentLbl);
		
		nextBtn = new Button("Next");
		nextBtn.addClickListener(e -> handleNextBtn());
		add(nextBtn);

	}
	
	
	
	@Override
	public String getName() {
		return ActivityView.VIEW_NAME;
	}


	@Override
	public void handleNextBtn() {
		this.viewController.setView();
		// TODO
//		presenter.nextBtnClicked(ActivityView.VIEW_NAME, getMotivationIndex());
	}

}
