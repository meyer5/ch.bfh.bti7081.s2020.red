package ch.bfh.btx8081.gui.shared.strategy;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.SelectionMode;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.FlexLayout;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.model.AvoidanceStrategy;
import ch.bfh.btx8081.model.Patient;

@Route(value = "strategies")
public class StrategiesView extends VerticalLayout implements StrategiesInterface {

	/**
	 * Idea: shows all available strategies of a specific patient and the
	 * possibility to create a new one
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	public static final String TITLE = "Stategies";

	private StrategiesListener presenter;

	private Grid<AvoidanceStrategy> strategiesList = new Grid<>(AvoidanceStrategy.class);
	private FormLayout layout;
	private final Button newStrategyButton;
	private final Button deleteButton;
	private final Button backButton;
	private boolean isOpen = false;

	public StrategiesView() {

		strategiesList.setSelectionMode(SelectionMode.SINGLE);
		
		newStrategyButton = new Button("Add new strategy");
		backButton = new Button("Back", event3 -> {
			presenter.hadleBackClick();
		});
		
		deleteButton = new Button("Delete strategy", event4 -> {
			if (strategiesList.getSelectedItems().isEmpty()) {
				
			} else {
			presenter.hadleDeleteStrategyClick((AvoidanceStrategy) strategiesList.getSelectedItems().toArray()[0]);
			}
		});

		layout = new FormLayout();

		newStrategyButton.addClickListener(event -> {

			TextArea newStrategy = new TextArea();
			Button saveButton = new Button("Save", event2 -> {
				this.presenter.hadleCreateStrategyClick(newStrategy.getValue());
			});
			
			FlexLayout strategyLayout = new FlexLayout();

			strategyLayout.add(newStrategy, saveButton);
			strategyLayout.expand(newStrategy);

			if (this.isOpen) {
				layout.removeAll();
				this.isOpen = false;
			} else {
				layout.add(strategyLayout);
				this.isOpen = true;
			}

		});

		HorizontalLayout buttonLayout = new HorizontalLayout();
		buttonLayout.add(newStrategyButton, deleteButton, backButton);

		add(new H2("Strategies"), layout, buttonLayout, strategiesList);
	}

	@Override
	public void setPatient(Patient patient) {
		strategiesList.setItems(patient.getDiary().getAvoidanceStrategies());
	}

	@Override
	public void addListener(StrategiesListener presenter) {
		this.presenter = presenter;
	}

}
