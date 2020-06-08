package ch.bfh.btx8081.gui.doctor.patientInfo;

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
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.model.Patient;

// Overview of the addiction for the patient. Shows different data
@Route(value = "patient-info")
public class PatientInfoView extends VerticalLayout implements PatientInfoInterface {

  private static final long serialVersionUID = 3407757504015724766L;
  public static final String TITLE = "Patient Info";

  private PatientInfoListener presenter;

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

  // Icons
  Icon iconEditInfo = VaadinIcon.USER_CARD.create();
  Icon iconOpenQuestions = VaadinIcon.QUESTION.create();
  Icon iconAllEntries = VaadinIcon.NOTEBOOK.create();
  Icon iconStrategies = VaadinIcon.MAGIC.create();
  Icon iconActivities = VaadinIcon.HANDS_UP.create();
  Icon iconLogOut = VaadinIcon.SIGN_OUT.create();
  Icon iconBack = VaadinIcon.BACKSPACE_A.create();

  public PatientInfoView() {

    // Create Buttons

    Button activitiesButton = new Button("Activities", iconActivities, event -> {
      presenter.hadleActivitiesClick();
    });

    Button strategiesButton = new Button("Strategies", iconStrategies, event -> {
      presenter.hadleStrategiesClick();
    });

    Button questionsButton = new Button("Open questions", iconOpenQuestions, event -> {
      presenter.hadleQuestionsClick();
    });

    Button editButton = new Button("Edit Info", iconEditInfo, event -> {
      presenter.hadleEditClick();
    });

    Button entriesListButton = new Button("Show all entries", iconAllEntries, event -> {
      presenter.hadleEntriesListClick();
    });

    Button logOutButton = new Button("Log out", iconLogOut, event -> {
      presenter.hadleLogOutClick();
    });

    Button backMainViewButton = new Button("Back to patient list", iconBack, event -> {
      presenter.hadleBackClick();
    });

    // Board
    Board board = new Board();
    board.addRow(getEntryOverview());

    // Fill layout
    vLayout1.add(fixPatientFName, fixPatientLName, fixAddictionLbl, fixInfo);
    vLayout2.add(patientFName, patientLName, addictionLbl, infoLbl);
    vLayout3.add(editButton, activitiesButton, strategiesButton);
    vLayout4.add(entriesListButton, questionsButton, backMainViewButton, logOutButton);

    vLayout1.setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
    vLayout2.setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
    vLayout3.setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
    vLayout4.setDefaultHorizontalComponentAlignment(Alignment.STRETCH);

    hLayout.setWidthFull();
    hLayout.add(vLayout1, vLayout2, vLayout3, vLayout4);

    add(new H2("Patient overview"), hLayout, board);
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
    calendar.set(now.getYear(), now.getMonthValue() - 1, now.getDayOfMonth());
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
    series.setData(1, 3, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 2, 0, 1, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1,
        1, 1, 1);

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
