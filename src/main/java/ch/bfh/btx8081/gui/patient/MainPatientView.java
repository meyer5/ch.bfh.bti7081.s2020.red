package ch.bfh.btx8081.gui.patient;

import com.vaadin.flow.component.board.Board;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.splitlayout.SplitLayoutVariant;
import com.vaadin.flow.router.Route;

import java.time.LocalDate;
import java.util.Calendar;

// Overview of the addiction for the patient. Shows different data
@Route(value = "main-patient")
public class MainPatientView extends VerticalLayout {
	private static final long serialVersionUID = 1L;

	public static final String TITLE = "AddictionView";

	private PatientPresenter presenter;

	private SplitLayout vSplitLayout = new SplitLayout();
	private VerticalLayout vLayoutLeft = new VerticalLayout();
	private VerticalLayout vLayoutRight = new VerticalLayout();

	// Label left
	Label fixPatientFName = new Label("First name");
	Label fixPatientLName = new Label("Last name");
	Label fixDoctorLbl = new Label("Doctor:");
	Label fixAddictionLbl = new Label("Addiction:");
	Label fixEntriesNumberLbl = new Label("Entries made");
	// Label right
	Label patientFName = new Label(".");
	Label patientLName = new Label(".");
	Label doctorLbl = new Label(".");
	Label addictionLbl = new Label(".");
	Label entriesNumberLbl = new Label(".");

	public MainPatientView() {
		// Fill left and right layout
		vLayoutLeft.add(fixPatientFName, fixPatientLName, fixDoctorLbl, fixAddictionLbl, fixEntriesNumberLbl);
		vLayoutRight.add(patientFName, patientLName, doctorLbl, addictionLbl, entriesNumberLbl);

		vLayoutLeft.setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
		vLayoutRight.setDefaultHorizontalComponentAlignment(Alignment.STRETCH);

		vSplitLayout.addToPrimary(vLayoutLeft);
		vSplitLayout.addToSecondary(vLayoutRight);
		vSplitLayout.setOrientation(SplitLayout.Orientation.HORIZONTAL);
		vSplitLayout.addThemeVariants(SplitLayoutVariant.LUMO_MINIMAL);
		vSplitLayout.setPrimaryStyle("max-width", "30%");
		vSplitLayout.setPrimaryStyle("min-width", "10%");
		vSplitLayout.setWidthFull();
		vSplitLayout.setHeight("50%");

		Board board = new Board();
		board.addRow(getEntryOverview());

		add(vSplitLayout);
		add(board);
	}

	// Returns a graph that shows, when a entry was made or not
	private Chart getEntryOverview() {
		Chart chart = new Chart();
		chart.setHeight("10%");
		Configuration conf = chart.getConfiguration();

		conf.getChart().setZoomType(Dimension.XY);
		conf.setTitle("Entry Overview");

		XAxis x = new XAxis();
		Calendar calendar = Calendar.getInstance();
		LocalDate now = LocalDate.now();
		calendar.set(now.getYear(), now.getMonthValue()-1, now.getDayOfMonth());
		int totalDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
		String[] days = new String[totalDays];
		for (int i = 0; i < totalDays; i++)
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

	public void setPresenter(PatientPresenter presenter) {
		this.presenter = presenter;
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

	public void setEntriesNumberLbl(String entriesNumberLbl) {
		this.entriesNumberLbl.setText(entriesNumberLbl);
	}
}
