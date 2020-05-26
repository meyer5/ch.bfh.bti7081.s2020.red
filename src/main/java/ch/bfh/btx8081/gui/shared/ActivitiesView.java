package ch.bfh.btx8081.gui.shared;

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

import ch.bfh.btx8081.model.Activity;
import ch.bfh.btx8081.model.Patient;

@Route(value = "activities")
public class ActivitiesView extends VerticalLayout implements ActivitiesInterface {
	
	/**
	 * Idea: shows all available activities of a specific patient and the
	 * possibility to create a new one
	 * 
	 */

	private static final long serialVersionUID = 1L;
	public static final String TITLE = "Activities";

	private ActivitiesListener presenter;

	private Grid<Activity> activitiesList = new Grid<>(Activity.class);
	private FormLayout layout;
	private final Button newActivityButton;
	private final Button deleteButton;
	private final Button backButton;
	private boolean isOpen = false;

	public ActivitiesView() {

		activitiesList.setSelectionMode(SelectionMode.SINGLE);
		
		newActivityButton = new Button("Add new activity");
		backButton = new Button("Back", event3 -> {
			presenter.hadleBackClick();
		});
		
		deleteButton = new Button("Delete activity", event4 -> {
			if (activitiesList.getSelectedItems().isEmpty()) {
				
			} else {
			presenter.hadleDeleteActivityClick((Activity) activitiesList.getSelectedItems().toArray()[0]);
			}
		});

		layout = new FormLayout();

		newActivityButton.addClickListener(event -> {

			TextArea newActivity = new TextArea();
			Button saveButton = new Button("Save", event2 -> {
				this.presenter.hadleSaveClick(newActivity.getValue(), "1111");
			});

			FlexLayout activityLayout = new FlexLayout();

			activityLayout.add(newActivity, saveButton);
			activityLayout.expand(newActivity);

			if (this.isOpen) {
				layout.removeAll();
				this.isOpen = false;
			} else {
				layout.add(activityLayout);
				this.isOpen = true;
			}

		});

		HorizontalLayout buttonLayout = new HorizontalLayout();
		buttonLayout.add(newActivityButton, deleteButton, backButton);

		add(new H2("Activities"), layout, buttonLayout, activitiesList);
	}

	@Override
	public void setPatient(Patient patient) {
		activitiesList.setItems(patient.getDiary().getActivities());
	}

	@Override
	public void addListener(ActivitiesListener presenter) {
		this.presenter = presenter;
	}
}