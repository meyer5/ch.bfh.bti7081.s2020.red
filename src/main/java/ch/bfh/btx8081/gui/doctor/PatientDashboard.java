package ch.bfh.btx8081.gui.doctor;

import com.vaadin.flow.component.board.Board;
import com.vaadin.flow.component.charts.Chart;
import com.vaadin.flow.component.charts.model.ChartType;
import com.vaadin.flow.component.charts.model.HorizontalAlign;
import com.vaadin.flow.component.charts.model.Label;
import com.vaadin.flow.component.charts.model.LayoutDirection;
import com.vaadin.flow.component.charts.model.Legend;
import com.vaadin.flow.component.charts.model.ListSeries;
import com.vaadin.flow.component.charts.model.PlotOptionsColumn;
import com.vaadin.flow.component.charts.model.VerticalAlign;
import com.vaadin.flow.component.charts.model.XAxis;
import com.vaadin.flow.component.charts.model.YAxis;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.router.internal.AbstractRouteRegistry.Configuration;

@Route(value = "dashboard", layout = DoctorMainUI.class)
public class PatientDashboard extends VerticalLayout {
	
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
		patientBoard.setText("This is statistic about patient");
		
	    setSizeFull();
	    Board board = new Board();
	    board.addRow(getColumnChart());
	    patientBoard.add(board);
		
		add(header);
		add(patientBoard);
		
    }
    
    private Chart getColumnChart(){
        Chart chart = new Chart(ChartType.COLUMN);

        
        return chart;
    }
    
}
