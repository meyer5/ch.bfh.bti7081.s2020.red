package ch.bfh.btx8081.gui.patient.newEntry;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * The last view of the entry process
 * patient confirms then the entry is stored
 * by the Presenter
 * 
 * @author Remo
 */

@Route(value="entry-confirm")
public class ConfirmView extends VerticalLayout implements PatientViewInterface {

	
	private static final long serialVersionUID = -1292549249513574336L;

	public static final String VIEW_NAME = "Confirm";
	private NewEntryPresenter patientPresenter;
	private EntryViewController viewController;
	private Label titleLbl;
	private Label commentLbl;
	private Button confirmBtn;
	
	public ConfirmView(NewEntryPresenter patientPresenter, EntryViewController viewController) {
		this.patientPresenter = patientPresenter;
		this.viewController = viewController;
		
		titleLbl = new Label("Confirmation");
		this.add(titleLbl);
		commentLbl = new Label("You have completed today's entry.");
		this.add(commentLbl);
		
		confirmBtn = new Button("Confirm");
		confirmBtn.addClickListener(e -> handleNextBtn());
		this.add(confirmBtn);
		
	}
	
	public boolean confirm() {
		return true;
	}

	@Override
	public String getName() {
		return ConfirmView.VIEW_NAME;
	}

	@Override
	public void handleNextBtn() {
		this.viewController.setView();
		this.patientPresenter.confirmBtnClicked(QuestionView.VIEW_NAME, confirm());
		
	}

}
