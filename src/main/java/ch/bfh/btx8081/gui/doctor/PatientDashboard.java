package ch.bfh.btx8081.gui.doctor;

import com.vaadin.flow.component.board.Board;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.*;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.*;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "Dashboard", layout = DoctorMainUI.class)
public class PatientDashboard extends VerticalLayout {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = 8567041458816914285L;
	public static final String TITLE = "Patient Dashboard";

    public PatientDashboard() {
		setPadding(true);
		//setSpacing(true);
		//setSizeFull();
		setDefaultHorizontalComponentAlignment(Alignment.STRETCH);

		final Div header = new Div();
		
        VerticalLayout formLayout = new VerticalLayout();
		
        H3 patientName = new H3("Patient Name");
        patientName.addClickListener(event -> patientName.setText("Test"));
        formLayout.add(patientName);
        
        header.add(formLayout);
		
		
		final Div patientBoard = new Div();
		patientBoard.setText("This is statistic of patient's addiction");
		
	    setSizeFull();
	    Board board = new Board();
	    board.addRow(getMixChart());
	    patientBoard.add(board);
		
		add(header);
		add(patientBoard);
		
    }
    
    private Chart getMixChart() {
        Chart chart = new Chart();
        Configuration conf = chart.getConfiguration();

        conf.getChart().setZoomType(Dimension.XY);
        conf.setTitle("Statistic of patient's addiction");
        //conf.setSubTitle("Source: WorldClimate.com");

        XAxis x = new XAxis();
        x.setCategories("1", "2", "3", "4", "5", "6", "7", "8",
                "9", "10", "11", "12");
        conf.addxAxis(x);

        YAxis y1 = new YAxis();
        y1.setShowEmpty(false);
        y1.setTitle(new AxisTitle("Motivation"));
        Labels labels = new Labels();
        labels.setFormatter("return this.value");
        y1.setLabels(labels);
        y1.setOpposite(true);
        y1.setClassName("y1");
        conf.addyAxis(y1);

        YAxis y2 = new YAxis();
        y2.setShowEmpty(false);
        y2.setTitle(new AxisTitle("Consumption"));
        labels = new Labels();
        labels.setFormatter("return this.value +' mm'");
        y2.setLabels(labels);
        y2.setClassName("y2");
        conf.addyAxis(y2);

		
		 YAxis y3 = new YAxis(); 
		 y3.setShowEmpty(false); 
		 y3.setTitle(new AxisTitle("Max Level Consumption")); 
		 labels = new Labels();
		 labels.setFormatter("return this.value +' mm'"); 
		 y3.setLabels(labels);
		 y3.setOpposite(true); 
		 y3.setClassName("y3"); 
		 conf.addyAxis(y3);
		 

			
		 Tooltip tooltip = new Tooltip();
			  
		 tooltip.setFormatter("function() { " +
			  "var unit = { 'Consumption': 'mm', 'Motivation': ':)', 'Max Level': 'mm' }[this.series.name];"
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

        DataSeries series = new DataSeries();
        PlotOptionsColumn plotOptionsColumn = new PlotOptionsColumn();
        series.setPlotOptions(plotOptionsColumn);
        series.setName("Consumption");
        series.setyAxis(1);
        series.setData(49.9, 71.5, 106.4, 129.2, 144.0, 176.0, 135.6, 148.5,
                216.4, 194.1, 95.6, 54.4);
        conf.addSeries(series);

        series = new DataSeries();
        PlotOptionsSpline plotOptionsSpline = new PlotOptionsSpline();
        series.setPlotOptions(plotOptionsSpline);
        series.setName("Max Level Consumption");
        //series.setyAxis(2);
        series.setData(6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6, 6);
        conf.addSeries(series);

        series = new DataSeries();
        plotOptionsSpline = new PlotOptionsSpline();
        series.setPlotOptions(plotOptionsSpline);
        series.setName("Motivation");
        series.setData(1, 2, 3, 4, 5, 4, 4, 3, 3, 2, 4, 4);
        conf.addSeries(series);
        
        return chart;

    }
    
}
