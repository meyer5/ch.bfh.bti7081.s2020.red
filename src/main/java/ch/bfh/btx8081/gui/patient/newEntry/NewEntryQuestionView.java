package ch.bfh.btx8081.gui.patient.newEntry;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

/**
 * View where patient can enter questions for the next session
 * 
 * @author Remo
 *
 */

@Route(value = "entry-question")
public class NewEntryQuestionView extends VerticalLayout implements NewEntryInterface {

  private static final long serialVersionUID = 1L;

  private NewEntryListener presenter;

  private Label title;
  private Label commentLbl;
  private Button nextBtn;
  private TextArea textArea;

  public NewEntryQuestionView() {

    // Label with title
    this.title = new Label("Questions");
    add(title);

    commentLbl = new Label("Questions");
    add(commentLbl);

    textArea = new TextArea();
    textArea.setPlaceholder("Do you have any questions for your next session?");
    add(textArea);

    nextBtn = new Button("Next");
    nextBtn.addClickListener(e -> {
      presenter.handleConfirmQuestion(textArea.getValue());
    });
    add(nextBtn);
  }

  @Override
  public void setListener(NewEntryListener presenter) {
    this.presenter = presenter;
  }

  @Override
  public void showNotification(String message) {
    Notification.show(message);
  }

}
