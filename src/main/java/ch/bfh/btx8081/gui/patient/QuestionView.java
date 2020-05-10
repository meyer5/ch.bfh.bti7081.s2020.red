package ch.bfh.btx8081.gui.patient;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;

public class QuestionView extends VerticalLayout implements PatientViewInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2232819652036225247L;

	public static final String VIEW_NAME = "Questions";

	private Presenter presenter;
	private EntryViewController viewController;
	private Label commentLbl;
	private Button nextBtn;
	private TextArea textArea;

	public QuestionView(Presenter presenter, EntryViewController viewController) {
		
		this.presenter = presenter;
		this.viewController = viewController;
		
		commentLbl = new Label("Questions");
		this.add(commentLbl);

		textArea = new TextArea();
		textArea.setPlaceholder("Do you have any questions for your next session?");
		this.add(textArea);

		// Next Button
		nextBtn = new Button("Next");
		// go to next view 
		//TODO what's next View???
		nextBtn.addClickListener(e -> handleNextBtn());
		// pass value to listener
		
		this.add(nextBtn);
	}
	
	public String getQuestions() {
		return textArea.getValue();
	}

	@Override
	public String getName() {
		return QuestionView.VIEW_NAME;
	}

	@Override
	public void handleNextBtn() {
		viewController.setView();
		this.presenter.nextBtnClicked(QuestionView.VIEW_NAME, getQuestions());
	}

	
	
}
