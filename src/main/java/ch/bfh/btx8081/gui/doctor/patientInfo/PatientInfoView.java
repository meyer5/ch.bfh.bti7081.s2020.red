package ch.bfh.btx8081.gui.doctor.patientInfo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import ch.bfh.btx8081.gui.doctor.patientInfo.PatientInfoInterface;
import ch.bfh.btx8081.model.Entry;
import com.vaadin.flow.component.board.Board;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.icon.Icon;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.model.Patient;

//Overview of the addiction for the patient. Shows different data
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
  Icon iconBack = VaadinIcon.ARROW_FORWARD.create();

  Board board = new Board();

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

    Button backButton = new Button("Back", iconBack, event -> {
      presenter.hadleBackClick();
    });

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
  }

  // Returns a graph that shows, when a entry was made or not
  private Chart getEntryOverview(List<Entry> entries) {
    Chart chart = new Chart();
    Configuration conf = chart.getConfiguration();

    conf.getChart().setZoomType(Dimension.XY);
    conf.setTitle("Statistic of patient's addiction");
    // conf.setSubTitle("Source: WorldClimate.com");

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
    y1.setTitle(new AxisTitle("Motivation"));
    Labels labels = new Labels();
    labels.setFormatter("return this.value");
    y1.setLabels(labels);
    y1.setOpposite(true);
    y1.setClassName("y1");
    conf.addyAxis(y1);

    YAxis y2 = new YAxis();
    y2.setShowEmpty(true);
    y2.setTitle(new AxisTitle("Consumption"));
    labels = new Labels();
    labels.setFormatter("return this.value +' mm'");
    y2.setLabels(labels);
    y2.setClassName("y2");
    conf.addyAxis(y2);

    YAxis y3 = new YAxis();
    y3.setShowEmpty(true);
    y3.setTitle(new AxisTitle("Max Level Consumption"));
    labels = new Labels();
    labels.setFormatter("return this.value +' mm'");
    y3.setLabels(labels);
    y3.setOpposite(true);
    y3.setClassName("y3");
    conf.addyAxis(y3);

    Tooltip tooltip = new Tooltip();

    tooltip.setFormatter("function() { "
            + "var unit = { 'Consumption': 'mm', 'Motivation': ':)', 'Max Level': 'mm' }[this.series.name];"
            + "return ''+ this.x +': '+ this.y +' '+ unit; }");

    conf.setTooltip(tooltip);

    Legend legend = new Legend();
    legend.setLayout(LayoutDirection.VERTICAL);
    legend.setAlign(HorizontalAlign.LEFT);
    legend.setX(120);
    legend.setVerticalAlign(VerticalAlign.TOP);
    legend.setY(80);
    legend.setFloating(true);
    conf.setLegend(legend);

    ArrayList<DataSeriesItem> itemsConsumtion = new ArrayList<>(totalDays);
    ArrayList<DataSeriesItem> itemsMotivation = new ArrayList<>(totalDays);
    ArrayList<DataSeriesItem> itemsMaxLevelConsumption = new ArrayList<>(totalDays);
    for (int i = 0; i < totalDays; i++)
    {
      itemsConsumtion.add(new DataSeriesItem(i, 0));
      itemsMotivation.add(new DataSeriesItem(i, 0));
      itemsMaxLevelConsumption.add(new DataSeriesItem(i, 0));
    }

    int latestEntryIndex = entries.size()-1;
    for (int i = latestEntryIndex; i > -1; i--)
    {
      LocalDate currentEntryDate = entries.get(i).getDate();

      if(LocalDate.now().getMonth() == currentEntryDate.getMonth()) {
        itemsConsumtion.set(currentEntryDate.getDayOfMonth() - 1, new DataSeriesItem(currentEntryDate.getDayOfMonth() - 1, entries.get(i).getConsumption()));
        itemsMotivation.set(currentEntryDate.getDayOfMonth() - 1, new DataSeriesItem(currentEntryDate.getDayOfMonth() - 1, entries.get(i).getMotivation()));
        itemsMaxLevelConsumption.set(currentEntryDate.getDayOfMonth() - 1, new DataSeriesItem(currentEntryDate.getDayOfMonth() - 1, entries.get(i).getPressureToConsume()));
      }
      else
        break;
    }

    DataSeries series = new DataSeries();
    PlotOptionsColumn plotOptionsColumn = new PlotOptionsColumn();
    series.setPlotOptions(plotOptionsColumn);
    series.setName("Consumption");
    series.setyAxis(1);
    series.setData(itemsConsumtion);
    conf.addSeries(series);

    series = new DataSeries();
    PlotOptionsSpline plotOptionsSpline = new PlotOptionsSpline();
    series.setPlotOptions(plotOptionsSpline);
    series.setName("Max Level Consumption");
    series.setData(itemsMaxLevelConsumption);
    conf.addSeries(series);

    series = new DataSeries();
    plotOptionsSpline = new PlotOptionsSpline();
    series.setPlotOptions(plotOptionsSpline);
    series.setName("Motivation");
    series.setData(itemsMotivation);
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

    board.addRow(getEntryOverview(patient.getDiary().getEntries()));
  }
}
