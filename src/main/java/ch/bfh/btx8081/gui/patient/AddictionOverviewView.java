package ch.bfh.btx8081.gui.patient;

import com.vaadin.flow.component.board.Board;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.splitlayout.SplitLayoutVariant;
import com.vaadin.flow.router.Route;

// Overview of the addiction for the patient. Shows different data
@Route(value="Addiction Overview"/*, layout = PatientMainUI.class*/)
public class AddictionOverviewView extends VerticalLayout
{
    public static final String TITLE = "AddictionView";

    private SplitLayout vSplitLayout = new SplitLayout();
    private VerticalLayout vLayoutLeft = new VerticalLayout();
    private VerticalLayout vLayoutRight = new VerticalLayout();

    public AddictionOverviewView()
    {
        // Label left
        Label labelLeft0 = new Label("Addiction");
        Label labelLeft1 = new Label("Doctor");
        Label labelLeft2 = new Label("Start of treatment");
        Label labelLeft3 = new Label("Days of progress");
        Label labelLeft4 = new Label("Entries made");
        Label labelLeft5 = new Label("Available activities");
        Label labelLeft6 = new Label("...");
        // Label right
        Label labelRight0 = new Label("Cocain");
        Label labelRight1 = new Label("Dr. Med. Fritzli");
        Label labelRight2 = new Label("1.1.1975");
        Label labelRight3 = new Label("20075");
        Label labelRight4 = new Label("10");
        Label labelRight5 = new Label("None");
        Label labelRight6 = new Label("...");
        // Fill left and right layout
        vLayoutLeft.add(labelLeft0, labelLeft1, labelLeft2, labelLeft3, labelLeft4, labelLeft5, labelLeft6);
        vLayoutRight.add(labelRight0, labelRight1, labelRight2, labelRight3, labelRight4, labelRight5, labelRight6);

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
    private Chart getEntryOverview()
    {
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
}
