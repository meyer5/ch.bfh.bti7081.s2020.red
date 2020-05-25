package ch.bfh.btx8081.gui.patient;

import java.util.ArrayList;

import com.vaadin.flow.component.board.Board;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.Configuration;
import com.vaadin.flow.component.charts.model.DataSeries;
import com.vaadin.flow.component.charts.model.Dimension;
import com.vaadin.flow.component.charts.model.Labels;
import com.vaadin.flow.component.charts.model.PlotOptionsColumn;
import com.vaadin.flow.component.charts.model.XAxis;
import com.vaadin.flow.component.charts.model.YAxis;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

// Overview of the addiction for the patient. Shows different data
@Route(value = "main-patient")
public class MainPatientView extends VerticalLayout implements MainPatientInterface {
	private static final long serialVersionUID = 1L;
	public static final String TITLE = "AddictionView";

	private ArrayList<MainPatientListener> listeners = new ArrayList<MainPatientListener>();

	private HorizontalLayout hLayout = new HorizontalLayout();
	private VerticalLayout vLayout1 = new VerticalLayout();
	private VerticalLayout vLayout2 = new VerticalLayout();
	private VerticalLayout vLayout3 = new VerticalLayout();
	private VerticalLayout vLayout4 = new VerticalLayout();

	// Label left
	Label fixPatientFName = new Label("First name");
	Label fixPatientLName = new Label("Last name");
	Label fixDoctorLbl = new Label("Doctor:");
	Label fixAddictionLbl = new Label("Addiction:");
	// Label right
	Label patientFName = new Label(".");
	Label patientLName = new Label(".");
	Label doctorLbl = new Label(".");
	Label addictionLbl = new Label(".");

	public MainPatientView() {

		// Create Buttons
		Button newEntryButton = new Button("Create new Entry", event -> {
			listeners.forEach(listener -> listener.handleNewEntryClick());
		});

		Button activitiesButton = new Button("Activities settings", event -> {
			listeners.forEach(listener -> listener.hadleActivitiesClick());
		});

		Button strategiesButton = new Button("Strategies settings", event -> {
			listeners.forEach(listener -> listener.hadleStrategiesClick());
		});

		Button QuestionsButton = new Button("Questions for doctor", event -> {
			listeners.forEach(listener -> listener.hadleQuestionsClick());
		});

		Button showStrategyButton = new Button("Show a strategy", event -> {
			listeners.forEach(listener -> listener.hadleShowStrategyClick());
		});

		Button alarmButton = new Button("Alarm", event -> {
			listeners.forEach(listener -> listener.hadleAlarmClick());
		});

		Button EntriesListButton = new Button("Show all entries", event -> {
			listeners.forEach(listener -> listener.hadleEntriesListClick());
		});

		// Fill layout
		vLayout1.add(fixPatientFName, fixPatientLName, fixDoctorLbl, fixAddictionLbl);
		vLayout2.add(patientFName, patientLName, doctorLbl, addictionLbl);
		vLayout3.add(newEntryButton, showStrategyButton, alarmButton, QuestionsButton);
		vLayout4.add(activitiesButton, strategiesButton, EntriesListButton);

		vLayout1.setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
		vLayout2.setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
		vLayout3.setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
		vLayout4.setDefaultHorizontalComponentAlignment(Alignment.STRETCH);

		hLayout.setWidthFull();
		hLayout.add(vLayout1, vLayout2, vLayout3, vLayout4);

		Board board = new Board();
		board.addRow(getEntryOverview());

		add(hLayout);
		add(board);
	}

	@Override
	public void addListener(MainPatientListener presenter) {
		listeners.add(presenter);
	}

	// Returns a graph that shows, when a entry was made or not
	private Chart getEntryOverview() {
		Chart chart = new Chart();
		chart.setHeight("10%");
		Configuration conf = chart.getConfiguration();

		conf.getChart().setZoomType(Dimension.XY);
		conf.setTitle("Entry Overview");

		XAxis x = new XAxis();
		String[] days = new String[31];
		for (int i = 0; i < 31; i++)
			days[i] = String.valueOf(i + 1);
		x.setCategories(days);
		conf.addxAxis(x);

		YAxis y1 = new YAxis();
		y1.setShowEmpty(true);
		y1.setOpposite(false);
		y1.setShowFirstLabel(false);
		y1.setShowLastLabel(false);
		y1.setAllowDecimals(false);
		y1.setCeiling(1);
		y1.setOrdinal(true);
		y1.setExtremes(1, 1);
		Labels yLabels = y1.getLabels();
		yLabels.setEnabled(false);
		y1.setClassName("y1");
		conf.addyAxis(y1);

		DataSeries series = new DataSeries();
		PlotOptionsColumn plotOptionsColumn = new PlotOptionsColumn();
		series.setPlotOptions(plotOptionsColumn);
		series.setName("Created Entries");
		series.setyAxis(0);
		series.setData(1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1);
		conf.addSeries(series);

		return chart;
	}

	public void setPatientFName(String patientFName) {
		System.out.println(this.patientFName.getText());
		this.patientFName.setText(patientFName);
		System.out.println(this.patientFName.getText());
	}

	public void setPatientLName(String patientLName) {
		this.patientLName.setText(patientLName);
	}

	public void setDoctorLbl(String doctorLbl) {
		this.doctorLbl.setText(doctorLbl);
	}

	public void setAddictionLbl(String addictionLbl) {
		this.addictionLbl.setText(addictionLbl);
	}

	@Override
	public void setPatient() {
		// TODO Auto-generated method stub

	}
}
