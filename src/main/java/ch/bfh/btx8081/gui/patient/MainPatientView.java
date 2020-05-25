package ch.bfh.btx8081.gui.patient;

import ch.bfh.btx8081.model.Entry;
import ch.bfh.btx8081.model.Patient;
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
import java.util.List;

// Overview of the addiction for the patient. Shows different data
@Route(value = "main-patient")
public class MainPatientView extends VerticalLayout {
	private static final long serialVersionUID = 1L;

	public static final String TITLE = "AddictionView";

	private PatientPresenter presenter;
	private Patient patient;

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
	Label patientFName = new Label(patient.getFirstName());
	Label patientLName = new Label(patient.getLastName());
	Label doctorLbl = new Label(patient.getDoctor().getFirstName() + " " + patient.getDoctor().getLastName());
	Label addictionLbl = new Label(patient.getAddiction());
	Label entriesNumberLbl = new Label(Integer.toString(patient.getDiary().getEntries().size()));

	public MainPatientView()
	{
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
		// reset every day
		for (int i = 0; i < totalDays; i++)
		{
			series.setyAxis(i);
			series.setData(0);
		}
		// Fill up days
		List<Entry> entries = patient.getDiary().getEntries();
		int latestEntryIndex = entries.size()-1;
		for (int i = latestEntryIndex; i > -1; i--)
		{
			LocalDate currentEntryDate = entries.get(i).getDate();
			if(LocalDate.now().getMonth() == currentEntryDate.getMonth())
			{
				series.setyAxis(currentEntryDate.getDayOfMonth()-1);
				series.setData(1);
			}
			else
				break;
		}
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
