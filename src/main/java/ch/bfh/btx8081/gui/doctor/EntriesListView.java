package ch.bfh.btx8081.gui.doctor;

import java.util.ArrayList;

import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.model.Entry;

@Route(value = "entries-list")
public class EntriesListView extends VerticalLayout implements EntriesListInterface {
	
	private static final long serialVersionUID = 2L;
	public static final String TITLE = "DiaryView";
	
	private ArrayList<EntriesListListener> listeners = new ArrayList<EntriesListListener>();

	private Grid<Entry> grid = new Grid<>(Entry.class);

	public EntriesListView() {
		loadDairy();
		createView();
	}

	private void loadDairy() {

	}

	private void createView() {
		H1 patientName = new H1("Emanuel WasAuchImmer");
		Label addiction = new Label("Addiction:");
		Label treatmentStart = new Label("Treatment start: ");
		Label totalEntries = new Label("Total Entries:");
		Label missedEntries = new Label("Missed Entries: ");

		add(patientName);
		add(addiction, treatmentStart, totalEntries, missedEntries);
		fillListWithEntries();
	}

	private void fillListWithEntries() {
		grid.setColumns("date");
		// grid.setHeight("500px");
		grid.setHeightByRows(true);
		add(grid);
	}

	@Override
	public void setPatient() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addListener(EntriesListListener presenter) {
		listeners.add(presenter);
	}
}
