package ch.bfh.btx8081.gui.patient;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public class ConfirmView extends VerticalLayout implements PatientViewInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1292549249513574336L;

	public static final String VIEW_NAME = "Confirm";
	private Presenter presenter;
	private EntryViewController viewController;
	private Label titleLbl;
	private Label commentLbl;
	private Button confirmBtn;
	
	public ConfirmView(Presenter presenter, EntryViewController viewController) {
		this.presenter = presenter;
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
		this.presenter.nextBtnClicked(QuestionView.VIEW_NAME, confirm());
	}

}
