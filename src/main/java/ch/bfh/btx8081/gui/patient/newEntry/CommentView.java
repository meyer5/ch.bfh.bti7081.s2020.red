package ch.bfh.btx8081.gui.patient.newEntry;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

/**
 * View where patient can enter comments for the doctor about
 * today's entry
 * 
 * @author Remo
 *
 */
@Route(value="entry-comment")
public class CommentView extends VerticalLayout implements PatientViewInterface {

	private static final long serialVersionUID = -3846334412179047472L;

	public static final String VIEW_NAME = "Comments";

	private NewEntryPresenter patientPresenter;
	private EntryViewController viewController;
	
	
	private Label commentLbl;
	private Button nextBtn;
	private TextArea textArea;

	public CommentView(NewEntryPresenter patientPresenter, EntryViewController viewController) {
		
		this.patientPresenter = patientPresenter;
		this.viewController = viewController;
		
		this.commentLbl = new Label("Comments");
		add(commentLbl);

		textArea = new TextArea();
		textArea.setPlaceholder("Write your comments here (if you want)");
		add(textArea);

		nextBtn = new Button("Next");
		nextBtn.addClickListener(e -> handleNextBtn());
		add(nextBtn);
	}
	
	
	private String getComment() {
		return textArea.getValue();
	}

	@Override
	public String getName() {
		return CommentView.VIEW_NAME;
	}


	@Override
	public void handleNextBtn() {
		this.viewController.setView();
		this.patientPresenter.nextBtnClicked(CommentView.VIEW_NAME, getComment());
	}
	
	
	
}
