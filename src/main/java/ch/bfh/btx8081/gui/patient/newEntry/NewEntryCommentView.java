package ch.bfh.btx8081.gui.patient.newEntry;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

/**
 * View where patient can enter comments for the doctor about today's entry
 * 
 * @author Remo
 *
 */
@Route(value = "entry-comment")
public class NewEntryCommentView extends VerticalLayout implements NewEntryInterface {

	private static final long serialVersionUID = 1L;

	private NewEntryListener presenter;

	private Label commentLbl;
	private Button nextBtn;
	private TextArea textArea;

	public NewEntryCommentView() {

		this.commentLbl = new Label("Comments");
		add(commentLbl);

		textArea = new TextArea();
		textArea.setPlaceholder("Write your comments here (if you want)");
		add(textArea);

		nextBtn = new Button("Next");
		nextBtn.addClickListener(e -> {
			presenter.handleConfirmComment(textArea.getValue());
		});
		add(nextBtn);
	}
	
	@Override
	public void setListener(NewEntryListener presenter) {
		this.presenter = presenter;
	}

}
