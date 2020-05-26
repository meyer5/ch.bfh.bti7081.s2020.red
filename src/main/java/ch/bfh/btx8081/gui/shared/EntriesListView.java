package ch.bfh.btx8081.gui.shared;

import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.grid.Grid;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.model.Entry;
import ch.bfh.btx8081.model.Patient;

@Route(value = "entries-list")
public class EntriesListView extends VerticalLayout implements EntriesListInterface {
	
	private static final long serialVersionUID = 2L;
	public static final String TITLE = "DiaryView";
	
	private EntriesListListener presenter;

	private Grid<Entry> grid = new Grid<>(Entry.class);

	public EntriesListView() {
		
		Button backButton = new Button("Back", event -> {
			presenter.hadleBackClick();
		});
		
		grid.addSelectionListener(event -> {
			this.presenter.hadleOpenEntryClick((Entry) grid.getSelectedItems().toArray()[0]);
		});
		grid.setColumns("date", "pressureToConsume", "motivation", "consumption");
		
		add(new H1("Entries list"), backButton, grid);
	}

	@Override
	public void setPatient(Patient patient) {
		grid.setItems(patient.getDiary().getEntries());
		
	}

	@Override
	public void addListener(EntriesListListener presenter) {
		this.presenter = presenter;
	}
}
