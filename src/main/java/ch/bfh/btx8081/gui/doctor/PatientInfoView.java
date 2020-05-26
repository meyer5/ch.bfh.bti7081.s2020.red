package ch.bfh.btx8081.gui.doctor;

import java.time.LocalDate;
import java.util.Calendar;

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
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.exceptions.UserNotFoundException;
import ch.bfh.btx8081.exceptions.WrongPasswordException;
import ch.bfh.btx8081.model.Patient;

//Overview of the addiction for the patient. Shows different data
@Route(value = "patient-info")
public class PatientInfoView extends VerticalLayout implements PatientInfoInterface {

	private static final long serialVersionUID = 3407757504015724766L;
	public static final String TITLE = "Patient Info";

	private PatientInfoListener presenter;

//	private List<Patient> patients = null;
//	Patient patient = null;
//	private VerticalLayout layout;
//	private DoctorService service = null;
//	private PersistenceManager persistenceManager = null;

	// Create Layouts
	private HorizontalLayout hLayout = new HorizontalLayout();
	private VerticalLayout vLayout1 = new VerticalLayout();
	private VerticalLayout vLayout2 = new VerticalLayout();
	private VerticalLayout vLayout3 = new VerticalLayout();
	private VerticalLayout vLayout4 = new VerticalLayout();

	// Label left
	private Label fixPatientFName = new Label("First name:");
	private Label fixPatientLName = new Label("Last name:");
	private Label fixAddictionLbl = new Label("Addiction:");
	
	// Label right
	private Label patientFName = new Label("First name");
	private Label patientLName = new Label("Last name");
	private Label addictionLbl = new Label("Addiction");
	
	// Label Info
	private Label fixInfo = new Label("Info:");
	private Label infoLbl = new Label("Info");

	public PatientInfoView() {

		// Create Buttons

		Button activitiesButton = new Button("Activities", event -> {
			presenter.hadleActivitiesClick();
		});

		Button strategiesButton = new Button("Strategies", event -> {
			presenter.hadleStrategiesClick();
		});

		Button questionsButton = new Button("Open questions", event -> {
			presenter.hadleQuestionsClick();
		});

		Button editButton = new Button("Edit Info", event -> {
			presenter.hadleEditClick();
		});

		Button entriesListButton = new Button("Show all entries", event -> {
			presenter.hadleEntriesListClick();
		});

		Button logOutButton = new Button("Log out", event -> {
			presenter.hadleLogOutClick();
		});
		
		Button backButton = new Button("Back", event -> {
			presenter.hadleBackClick();
		});
		
		// Board
		Board board = new Board();
		board.addRow(getEntryOverview());

		// Fill layout
		vLayout1.add(fixPatientFName, fixPatientLName, fixAddictionLbl, fixInfo);
		vLayout2.add(patientFName, patientLName, addictionLbl, infoLbl);
		vLayout3.add(activitiesButton, strategiesButton, questionsButton, editButton);
		vLayout4.add(entriesListButton, backButton, logOutButton);

		vLayout1.setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
		vLayout2.setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
		vLayout3.setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
		vLayout4.setDefaultHorizontalComponentAlignment(Alignment.STRETCH);

		hLayout.setWidthFull();
		hLayout.add(vLayout1, vLayout2, vLayout3, vLayout4);
		
		add(new H2("Patient overview"), hLayout, board);

//		this.patient = new Patient();
//		this.persistenceManager = new PersistenceManager();
//		this.patients = persistenceManager.getPatients();
//
//		final EditPatientView patientShowLayout = new EditPatientView();
//		layout = new VerticalLayout();
//
//		for (Patient p : patients) {
//			System.out.println(p.getUserName());
//			if (p.getUserName().equals("natalya")) {
//				this.patient = p;
//			}
	}

//		patientShowLayout.setFirstName(patient.getFirstName());
//		patientShowLayout.setLastName(patient.getLastName());
//		patientShowLayout.setPhoneNumber(patient.getPhoneNumber());
//		patientShowLayout.setEMail(patient.geteMail());
//		patientShowLayout.setDoctor(patient.getDoctor().getFirstName());
//
//		// Build a footer, add Save and Cancel buttons
//		final HorizontalLayout footer = new HorizontalLayout();
//
//		// Browser page is updated
//		Button buttonCancel = new Button("Cancel");
//		buttonCancel.addClickListener(event -> UI.getCurrent().getPage().reload());
//
//		// Changed fields will be saved and browser page is updated
//		Button buttonEdit = new Button("Edit", event -> {
//			try {
//				service.changeMainInfo(patientShowLayout.getMainInfo().getValue());
//
//				service.changeContactInfo(patientShowLayout.getFirstName().getValue(),
//						patientShowLayout.getLastName().getValue(), patientShowLayout.getPhoneNumber().getValue(),
//						patientShowLayout.getEMail().getValue());
//
//				service.setConditionAutomaticAlarm(patientShowLayout.getConditionAutomaticAlarm().getValue());
//
//				System.out.println(patientShowLayout.getMainInfo().getValue());
//				System.out.println(patientShowLayout.getFirstName().getValue());
//
//				UI.getCurrent().getPage().reload();
//
//			} catch (final Exception e) {
//				e.printStackTrace();
//			}
//		});
//
//		footer.getThemeList().set("spacing", true);
//		footer.add(buttonEdit, buttonCancel);
//		layout.add(patientShowLayout, footer);
//		add(layout);
//		expand(layout);
//	}
	
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
			series.setData(1, 3, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 2, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1);

			conf.addSeries(series);

			return chart;
		}

	@Override
	public void addListener(PatientInfoListener presenter) {
		this.presenter = presenter;

	}

	@Override
	public void setPatient(Patient patient) {
		patientFName.setText(patient.getFirstName());
		patientLName.setText(patient.getLastName());
		addictionLbl.setText(patient.getAddiction());
		infoLbl.setText(patient.getMainInfo());
	}
}
