package ch.bfh.btx8081.gui.patient;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;

public class CommentView extends VerticalLayout implements PatientViewInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3846334412179047472L;

	public static final String VIEW_NAME = "Comments";

	private Presenter presenter;
	private EntryViewController viewController;
	
	private Label commentLbl;
	private Button nextBtn;
	private TextArea textArea;

	public CommentView(Presenter presenter, EntryViewController viewController) {
		
		this.presenter = presenter;
		this.viewController = viewController;
		
		commentLbl = new Label("Comments");
		add(commentLbl);

		textArea = new TextArea();
		textArea.setPlaceholder("Write your comments here (if you want)");
		add(textArea);

		// Next Button
		nextBtn = new Button("Next");
		// go to next view 
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
		this.presenter.nextBtnClicked(CommentView.VIEW_NAME, getComment());
	}
	
	
	
}
