package ch.bfh.btx8081.gui.patient;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;

/**
 * View where patient can enter questions for the next session
 * @author Remo
 *
 */
public class QuestionView extends VerticalLayout implements PatientViewInterface {

	private static final long serialVersionUID = 2232819652036225247L;

	public static final String VIEW_NAME = "Questions";

	private Presenter presenter;
	private EntryViewController viewController;
	
	private Label title;
	private Label commentLbl;
	private Button nextBtn;
	private TextArea textArea;

	public QuestionView(Presenter presenter, EntryViewController viewController) {
		
		this.presenter = presenter;
		this.viewController = viewController;
		
		// Label with title
		this.title = new Label("Questions");
		add(title);
		
		commentLbl = new Label("Questions");
		add(commentLbl);

		textArea = new TextArea();
		textArea.setPlaceholder("Do you have any questions for your next session?");
		add(textArea);


		nextBtn = new Button("Next");
		nextBtn.addClickListener(e -> handleNextBtn());
		add(nextBtn);
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
