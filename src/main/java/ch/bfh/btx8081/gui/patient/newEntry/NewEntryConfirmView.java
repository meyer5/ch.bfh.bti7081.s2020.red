package ch.bfh.btx8081.gui.patient.newEntry;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

/**
 * The last view of the entry process patient confirms then the entry is stored by the Presenter
 * 
 * @author Remo
 */

@Route(value = "entry-confirm")
public class NewEntryConfirmView extends VerticalLayout implements NewEntryInterface {

  private static final long serialVersionUID = 1L;

  private NewEntryListener presenter;

  private Label titleLbl;
  private Label commentLbl;
  private Button confirmBtn;

  public NewEntryConfirmView() {
    titleLbl = new Label("Confirmation");
    this.add(titleLbl);
    commentLbl = new Label("You have completed today's entry.");
    this.add(commentLbl);

    confirmBtn = new Button("Confirm");
    confirmBtn.addClickListener(e -> {
      presenter.handleConfirmEntry();
    });
    this.add(confirmBtn);

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
