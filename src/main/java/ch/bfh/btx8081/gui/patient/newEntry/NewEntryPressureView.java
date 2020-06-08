package ch.bfh.btx8081.gui.patient.newEntry;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.router.Route;

/**
 * View where patient can enter felt pressure to consume on a given scale
 * 
 * @author Remo
 *
 */

@Route(value = "entry-pressure")
public class NewEntryPressureView extends VerticalLayout implements NewEntryInterface {

  private static final long serialVersionUID = 1L;

  private NewEntryListener presenter;

  private Label title;
  private NumberField pressureLevel;
  private Label pressureLbl;
  private Button nextBtn;

  public NewEntryPressureView() {

    // Label with title
    this.title = new Label("Pressure");
    add(title);
    // Label with instruction
    pressureLbl = new Label("Enter your consumtion pressure on a scale from 1 to 10");
    add(pressureLbl);

    // NumberField
    pressureLevel = new NumberField();
    pressureLevel.setValue(1d);
    pressureLevel.setHasControls(true);
    pressureLevel.setMin(1);
    pressureLevel.setMax(10);
    this.add(pressureLevel);

    // Next Button
    nextBtn = new Button("Next");
    nextBtn.addClickListener(e -> {
      try {
        presenter.handleConfirmPressure(pressureLevel.getValue().intValue());
      } catch (NullPointerException a) {
        this.showNotification("Input is invalid. Try again");
      }
      
    });
    this.add(nextBtn);

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
