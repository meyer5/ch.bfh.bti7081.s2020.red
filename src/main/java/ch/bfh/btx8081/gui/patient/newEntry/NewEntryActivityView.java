package ch.bfh.btx8081.gui.patient.newEntry;

import java.util.ArrayList;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.grid.Grid.SelectionMode;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.model.Activity;

/**
 * View where Patient can choose one or more activities he performed in order to
 * avoid consumption
 * 
 * @author Remo
 *
 */
@Route(value = "entry-activity")
public class NewEntryActivityView extends VerticalLayout implements NewEntryInterface {

	private static final long serialVersionUID = 1L;

	private NewEntryListener presenter;

	private Grid<Activity> activitiesList = new Grid<>(Activity.class);

	private Label title;
	private Label commentLbl;
	private Button nextBtn;

	public NewEntryActivityView() {

		this.title = new Label("Activities");
		add(title);

		this.commentLbl = new Label("What did you do today?");
		add(commentLbl);

		nextBtn = new Button("Next");
		nextBtn.addClickListener(e -> {
			presenter.handleConfirmActivities(new ArrayList<Activity>(activitiesList.getSelectedItems()));
		});
		add(nextBtn);

		activitiesList.setSelectionMode(SelectionMode.MULTI);
		add(activitiesList);

	}

	@Override
	public void setListener(NewEntryListener presenter) {
		this.presenter = presenter;
		activitiesList.setItems(presenter.getActivities());
	}

}
