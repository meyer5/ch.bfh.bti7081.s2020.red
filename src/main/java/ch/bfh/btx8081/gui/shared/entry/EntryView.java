package ch.bfh.btx8081.gui.shared.entry;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.model.Activity;
import ch.bfh.btx8081.model.Entry;

@Route(value = "day-details")
public class EntryView extends VerticalLayout implements EntryInterface {
	
	private static final long serialVersionUID = 3L;
	public static final String TITLE = "entry";
	
	private EntryListener presenter;

	VerticalLayout vLayoutLeft = new VerticalLayout();
    VerticalLayout vLayoutRight = new VerticalLayout();
    HorizontalLayout hLayout = new HorizontalLayout();
	
	Label dateTextLabel = new Label("Date:");
	Label consumptionTextLabel = new Label("Consumption:");
	Label pressureToConsumeTextLabel = new Label("Pressure to consume:");
	Label motivationTextLabel = new Label("Motivation:");
	Label commentTextLabel = new Label("Comment:");
	Label questionForConsultationTextLabel = new Label("Question for consultation:");
	Label activitiesTextLabel = new Label("Activities:");
	
	Label dateLabel = new Label("");
	Label consumptionLabel = new Label("");
	Label pressureToConsumeLabel = new Label("");
	Label motivationLabel = new Label("");
	Label commentLabel = new Label("");
	Label questionForConsultationLabel = new Label("");
	
	public EntryView() {
		
		Button backToMain = new Button("Back to overview", event3 -> {
			presenter.hadleBackToMainClick();
		});
		
		Button backToList = new Button("Back to entries list", event3 -> {
			presenter.hadleBackToListClick();
		});

		vLayoutLeft.add(backToMain, dateTextLabel, consumptionTextLabel, pressureToConsumeTextLabel, motivationTextLabel, commentTextLabel, questionForConsultationTextLabel, activitiesTextLabel);
		vLayoutRight.add(backToList, dateLabel, consumptionLabel, pressureToConsumeLabel, motivationLabel, commentLabel, questionForConsultationLabel);
		hLayout.add(vLayoutLeft, vLayoutRight);
		add(hLayout);
	}

	@Override
	public void setEntry(Entry entry) {
		dateLabel.setText(entry.getDate().toString());
		consumptionLabel.setText(Long.toString(entry.getConsumption()));
		pressureToConsumeLabel.setText(Integer.toString(entry.getPressureToConsume()));
		motivationLabel.setText(Integer.toString(entry.getMotivation()));
		commentLabel.setText(entry.getComment());
		if (entry.getQuestionsForConsultation() != null) {
			questionForConsultationLabel.setText(entry.getQuestionsForConsultation().getQuestion());
		}
		for (Activity a : entry.getActivities()) {
			vLayoutRight.add(new Label(a.getActivity()));
		}
		
	}

	@Override
	public void addListener(EntryListener presenter) {
		this.presenter = presenter;	
	}
}
