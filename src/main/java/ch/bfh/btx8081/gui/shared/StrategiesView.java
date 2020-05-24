package ch.bfh.btx8081.gui.shared;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.model.AvoidanceStrategy;
import ch.bfh.btx8081.model.Patient;

@Route(value = "stategies")
public class StrategiesView extends VerticalLayout {

  /**
   * Idea: shows all available strategies of a specific patient 
   * and the possibility to create a new one
   * 
   */

  public static final String TITLE = "Stategies";


  private Grid<AvoidanceStrategy> strategiesList = new Grid<>(AvoidanceStrategy.class);
  private FormLayout layout;
  private final Button newStrategyButton;
  private final Button saveButton;
  private final Button deleteButton;
  private final Button cancelButton;


  public StrategiesView() {

    newStrategyButton = new Button("Add new strategy");
    saveButton = new Button("Save");
    cancelButton = new Button("Cancel");
    deleteButton = new Button("Delete");

    layout = new FormLayout();
  

    newStrategyButton.addClickListener(event -> {

      FlexLayout questionLayout = new FlexLayout();

      TextArea newStrategy = new TextArea();
      Checkbox checkbox = new Checkbox();

      questionLayout.add(newStrategy, checkbox);
      questionLayout.expand(newStrategy);

      layout.add(questionLayout);

     
    });
  

    HorizontalLayout buttonLayout = new HorizontalLayout();
    buttonLayout.add(saveButton, deleteButton, cancelButton);

    add(new H2("Strategies"), newStrategyButton, layout, buttonLayout, strategiesList);
  }

}
