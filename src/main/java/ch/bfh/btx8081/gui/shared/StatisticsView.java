package ch.bfh.btx8081.gui.shared;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.AxisTitle;
import com.vaadin.flow.component.charts.model.Configuration;
import com.vaadin.flow.component.charts.model.DataSeries;
import com.vaadin.flow.component.charts.model.PlotOptionsSpline;
import com.vaadin.flow.component.charts.model.XAxis;
import com.vaadin.flow.component.charts.model.YAxis;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.radiobutton.RadioButtonGroup;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.model.Entry;
import ch.bfh.btx8081.model.Patient;


@Route(value = "statistics")
public class StatisticsView extends VerticalLayout
{
    private static final long serialVersionUID = 4L;
    public static final String TITLE = "Statistics";

    List<Entry> entries;
    Chart chart;
    Configuration config;

    public StatisticsView(Patient patient)
    {
    	entries = patient.getDiary().getEntries();

        RadioButtonGroup<String> radioGroup = new RadioButtonGroup<>();
        radioGroup.setLabel("Options");
        radioGroup.setItems("Consumption", "Pressure to consume", "Motivation");
        radioGroup.setValue("Consumption");
        radioGroup.addValueChangeListener(event ->
        {
            generateGraph(event.getValue());
        });

        add(radioGroup);

        generateGraph(radioGroup.getValue());
    }

    void generateGraph(String selected)
    {
        System.out.println(selected);

        chart = new Chart();
        config = chart.getConfiguration();

        XAxis x = new XAxis();
        int totalDays = (int)ChronoUnit.DAYS.between(entries.get(0).getDate(), LocalDate.now());
        String[] days = new String[totalDays];
        for (int i = 0; i < totalDays; i++)
            days[i] = Integer.toString(i);
        x.setCategories(days);
        config.addxAxis(x);

        YAxis y1 = new YAxis();
        y1.setShowEmpty(true);
        y1.setTitle(new AxisTitle("selected"));
        y1.setOpposite(true);
        y1.setClassName("y1");
        config.addyAxis(y1);

        DataSeries series = new DataSeries();
        PlotOptionsSpline plotOptionsSpline = new PlotOptionsSpline();
        series.setPlotOptions(plotOptionsSpline);
        series.setName(selected);

        int dayCounter = 0;
        for (int i = 0; i < totalDays; i++)
        {
            int diff = (int)ChronoUnit.DAYS.between(entries.get(0).getDate(), entries.get(dayCounter).getDate());
            if(diff != 0)
            {
                series.setyAxis(i);
                if(selected == "Confirmation")
                    series.setData(entries.get(i).getConsumption());
                else if(selected == "Pressure")
                    series.setData(entries.get(i).getPressureToConsume());
                else if(selected == "Motivation")
                    series.setData(entries.get(i).getMotivation());
            }
        }
        config.addSeries(series);
    }
}
