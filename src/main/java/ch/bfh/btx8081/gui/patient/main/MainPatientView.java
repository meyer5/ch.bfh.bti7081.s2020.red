package ch.bfh.btx8081.gui.patient.main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ch.bfh.btx8081.model.Entry;
import com.vaadin.flow.component.board.Board;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.charts.model.Dimension;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.model.Patient;


// Overview of the addiction for the patient. Shows different data
@Route(value = "main-patient")
public class MainPatientView extends VerticalLayout implements MainPatientInterface {

  private static final long serialVersionUID = 1L;

  private MainPatientListener presenter;


  private HorizontalLayout hLayout = new HorizontalLayout();
  private VerticalLayout vLayout1 = new VerticalLayout();
  private VerticalLayout vLayout2 = new VerticalLayout();
  private VerticalLayout vLayout3 = new VerticalLayout();
  private VerticalLayout vLayout4 = new VerticalLayout();

  // Label left
  private Label fixPatientFName = new Label("First name:");
  private Label fixPatientLName = new Label("Last name:");
  private Label fixDoctorLbl = new Label("Doctor:");
  private Label fixAddictionLbl = new Label("Addiction:");
  // Label right

  private Label patientFName = new Label("First name");
  private Label patientLName = new Label("Last name");
  private Label doctorLbl = new Label("Doctor");
  private Label addictionLbl = new Label("Addiction");

  // Icons
  Icon iconNewEntry = VaadinIcon.FILE_ADD.create();
  Icon iconOpenQuestions = VaadinIcon.QUESTION.create();
  Icon iconAllEntries = VaadinIcon.NOTEBOOK.create();
  Icon iconStrategies = VaadinIcon.MAGIC.create();
  Icon iconActivities = VaadinIcon.HANDS_UP.create();
  Icon iconLogOut = VaadinIcon.SIGN_OUT.create();
  Icon iconBack = VaadinIcon.ARROW_FORWARD.create();
  Icon iconAlarm = VaadinIcon.BELL_O.create();
  Icon iconShowStrategy = VaadinIcon.FROWN_O.create();

  Board board = new Board();

  public MainPatientView() {

    // Create Buttons
    Button newEntryButton = new Button("Create new entry", iconNewEntry, event -> {
      presenter.handleNewEntryClick();
    });

    Button activitiesButton = new Button("Activities", iconActivities, event -> {
      presenter.hadleActivitiesClick();
    });

    Button strategiesButton = new Button("Strategies", iconStrategies, event -> {
      presenter.hadleStrategiesClick();
    });

    Button questionsButton = new Button("Questions for doctor", iconOpenQuestions, event -> {
      presenter.hadleQuestionsClick();
    });

    Button showStrategyButton = new Button("Show a strategy", iconShowStrategy, event -> {
      presenter.hadleShowStrategyClick();
    });

    Button alarmButton = new Button("Alarm", iconAlarm, event -> {
      presenter.hadleAlarmClick();
    });

    Button entriesListButton = new Button("Show all entries", iconAllEntries, event -> {
      presenter.hadleEntriesListClick();
    });

    Button logOutButton = new Button("Log out", iconLogOut, event -> {
      presenter.hadleLogOutClick();
    });

    // Fill layout
    vLayout1.add(fixPatientFName, fixPatientLName, fixDoctorLbl, fixAddictionLbl);
    vLayout2.add(patientFName, patientLName, doctorLbl, addictionLbl);
    vLayout3.add(newEntryButton, showStrategyButton, alarmButton, questionsButton);
    vLayout4.add(activitiesButton, strategiesButton, entriesListButton, logOutButton);

    vLayout1.setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
    vLayout2.setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
    vLayout3.setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
    vLayout4.setDefaultHorizontalComponentAlignment(Alignment.STRETCH);

    hLayout.setWidthFull();
    hLayout.add(vLayout1, vLayout2, vLayout3, vLayout4);

    add(new H2("Overview"), hLayout, board);
  }

  @Override
  public void setPresenter(MainPatientListener presenter) {
    this.presenter = presenter;
  }

  // Returns a graph that shows, when a entry was made or not
  private Chart getEntryOverview(List<Entry> entries) {
    Chart chart = new Chart();
    chart.setHeight("10%");
    Configuration conf = chart.getConfiguration();

    conf.getChart().setZoomType(Dimension.XY);
    conf.setTitle("Entry Overview");

    Calendar calendar = Calendar.getInstance();
    LocalDate now = LocalDate.now();
    calendar.set(now.getYear(), now.getMonthValue()-1, now.getDayOfMonth());
    int totalDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);
    String[] days = new String[totalDays];
    for (int i = 0; i < totalDays; i++)
      days[i] = String.valueOf(i + 1);

    XAxis x = new XAxis();
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
    y1.setExtremes(0,1);
    Labels yLabels = y1.getLabels();
    yLabels.setEnabled(false);
    y1.setClassName("y1");
    conf.addyAxis(y1);

    DataSeries series = new DataSeries();
    PlotOptionsColumn plotOptionsColumn = new PlotOptionsColumn();
    series.setPlotOptions(plotOptionsColumn);
    series.setName("Created Entries");

    ArrayList<DataSeriesItem> items = new ArrayList<>(totalDays);
    for (int i = 0; i < totalDays; i++)
      items.add(new DataSeriesItem(i, 0));

    int latestEntryIndex = entries.size()-1;
    for (int i = latestEntryIndex; i > -1; i--)
    {
      LocalDate currentEntryDate = entries.get(i).getDate();

      if(LocalDate.now().getMonth() == currentEntryDate.getMonth())
        items.set(currentEntryDate.getDayOfMonth()-1, new DataSeriesItem(currentEntryDate.getDayOfMonth()-1, 1));
      else
        break;
    }
    series.setData(items);
    conf.addSeries(series);

    return chart;
  }

  //	Show the information of logged in patient
  @Override
  public void setPatient(Patient patient) {
    patientFName.setText(patient.getFirstName());
    patientLName.setText(patient.getLastName());
    doctorLbl.setText(patient.getDoctor().getFirstName());
    addictionLbl.setText(patient.getAddiction());

    board.addRow(getEntryOverview(patient.getDiary().getEntries()));
  }

  @Override
  public void showAvoidanceSrategy(String strategy) {
    VerticalLayout layout = new VerticalLayout();

    Dialog dialog = new Dialog();
    Button closeButton = new Button("OK", event -> {
      dialog.close();
    });

    layout.getMaxWidth();
    layout.setAlignItems(Alignment.CENTER);
    layout.add(new Label(strategy), closeButton);

    dialog.add(layout);
    dialog.open();
  }
}