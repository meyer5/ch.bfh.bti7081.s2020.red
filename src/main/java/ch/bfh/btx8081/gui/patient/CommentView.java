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

	private ViewListenerInterface presenter;

	private Label commentLbl;
	private Button nextBtn;
	private TextArea textArea;

	public CommentView(NewEntryView baseView) {
		
		presenter = new Presenter();
		
		commentLbl = new Label("Comments");
		this.add(commentLbl);

		textArea = new TextArea();
		textArea.setPlaceholder("Write your comments here (if you want)");
		this.add(textArea);

		// Next Button
		nextBtn = new Button("Next");
		// go to next view 
		//TODO what's next View???
		nextBtn.addClickListener(e -> baseView.setView(baseView.getConsumptionView()));
		// pass value to listener
		presenter.nextBtnClicked(this.VIEW_NAME, getComment());
		this.add(nextBtn);
	}
	
	public String getComment() {
		return textArea.getValue();
	}
	
	@Override
	public void addListener(ViewListenerInterface listener) {
		this.presenter = listener;	
	}
	
}
