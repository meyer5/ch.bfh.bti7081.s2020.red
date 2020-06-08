package ch.bfh.btx8081.gui.patient.newEntry;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.Route;

/**
 * View where patient enters his motivation on a given scale
 * 
 * @author Remo
 *
 */

@Route(value = "entry-motivation")
public class NewEntryMotivationView extends VerticalLayout implements NewEntryInterface {

  private static final long serialVersionUID = 1L;

  private NewEntryListener presenter;

  private Label title;
  private NumberField motivationLevel;
  private Label motivationLbl;
  private Button nextBtn;

  public NewEntryMotivationView() {

    // Label with title
    this.title = new Label("Motivation");
    add(title);
    // Label with instruction
    this.motivationLbl = new Label("Enter your motivation on a scale from 1 to 10");
    add(motivationLbl);

    // NumberField
    motivationLevel = new NumberField();
    motivationLevel.setValue(1d);
    motivationLevel.setHasControls(true);
    motivationLevel.setMin(1);
    motivationLevel.setMax(10);
    add(motivationLevel);

    // Next Button
    nextBtn = new Button("Next");
    // go to next view
    nextBtn.addClickListener(e -> {
      try {
        presenter.handleConfirmMotivation(motivationLevel.getValue().intValue());
      } catch (NullPointerException b) {
        this.showNotification("Input is invalid. Try again");
      }
    });
    // pass value to listener
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
