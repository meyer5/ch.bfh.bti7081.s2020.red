package ch.bfh.btx8081.gui.patient.newEntry;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

/**
 * View where patient can enter questions for the next session
 * @author Remo
 *
 */

@Route(value = "entry-question")
public class QuestionView extends VerticalLayout implements PatientViewInterface {

	private static final long serialVersionUID = 2232819652036225247L;

	public static final String VIEW_NAME = "Questions";

	private NewEntryPresenter patientPresenter;
	private EntryViewController viewController;
	
	private Label title;
	private Label commentLbl;
	private Button nextBtn;
	private TextArea textArea;

	public QuestionView(NewEntryPresenter patientPresenter, EntryViewController viewController) {
		
		this.patientPresenter = patientPresenter;
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
		this.patientPresenter.nextBtnClicked(QuestionView.VIEW_NAME, getQuestions());
	}

	
	
}
