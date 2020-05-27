package ch.bfh.btx8081.gui.patient.newEntry;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.FlexComponent.Alignment;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import ch.bfh.btx8081.model.Activity;

/**
 * Marker Interface for Presenter makes sure every view has a method to handle
 * the "Next" button and to pass the name of the view
 * 
 * @author Remo
 */
public interface NewEntryInterface {

	public void setListener(NewEntryListener presenter);
	
	public default void showAvoidanceSrategy(String strategy) {
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

	public interface NewEntryListener {
		
		public void handleConfirmDate(LocalDate date);
		
		public void handleConfirmConsumption(long consumption);
		
		public void handleConfirmPressure(int pressure);
		
		public void handleConfirmMotivation(int motivation);

		public void handleConfirmActivities(ArrayList<Activity> activities);

		public void handleConfirmComment(String comment);
		
		public void handleConfirmQuestion(String question);

		public void handleConfirmEntry();
		
		public List<Activity> getActivities();
		
		public void setView(NewEntryInterface view);

	}

}
