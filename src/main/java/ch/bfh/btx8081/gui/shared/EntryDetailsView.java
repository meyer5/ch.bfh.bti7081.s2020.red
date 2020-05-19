package ch.bfh.btx8081.gui.shared;

import ch.bfh.btx8081.model.Activity;
import ch.bfh.btx8081.model.Entry;
import ch.bfh.btx8081.model.QuestionForConsultation;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.splitlayout.SplitLayout;
import com.vaadin.flow.component.splitlayout.SplitLayoutVariant;
import com.vaadin.flow.router.Route;

import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;

@Route(value = "entry-details")
public class EntryDetailsView extends VerticalLayout
{
    private static final long serialVersionUID = 3L;
    public static final String TITLE = "entry";

    VerticalLayout vLayoutLeft = new VerticalLayout();
    VerticalLayout vLayoutRight = new VerticalLayout();
    SplitLayout vSplitLayout = new SplitLayout();

    public EntryDetailsView()
    {
        // TODO: Remove after persistance available
        QuestionForConsultation q = new QuestionForConsultation("BlaBla");
        ArrayList<Activity> activities = new ArrayList<>();
        activities.add(new Activity("Swimming", "temp1"));
        activities.add(new Activity("Running", "temp2"));
        // activities.add(new Activity("Others", "temp3"));
        // activities.add(new Activity("Others", "temp3"));
        // activities.add(new Activity("Others", "temp3"));
        // activities.add(new Activity("Others", "temp3"));
        LocalDate date = LocalDate.now();
        Entry e = new Entry(date, 12, 23, 34, activities, "BlaBla", q);

        setupView(e);
    }

    private void setupView(Entry entry)
    {
        Label dateTextLabel = new Label("Date:");
        Label consumptionTextLabel = new Label("Consumption:");
        Label pressureToConsumeTextLabel = new Label("Pressure to consume:");
        Label motivationTextLabel = new Label("motivation:");
        Label activitiesTextLabel = new Label("Activites:");
        activitiesTextLabel.setHeight((25 + (entry.getActivities().size() - 1) * 42) + "px");
        Label commentTextLabel = new Label("Comment:");
        Label questionForConsultationTextLabel = new Label("QuestionForConsultation:");

        vLayoutLeft.add(dateTextLabel, consumptionTextLabel, pressureToConsumeTextLabel, motivationTextLabel, activitiesTextLabel, commentTextLabel, questionForConsultationTextLabel);

        Label dateLabel = new Label(entry.getDate().toString());
        Label consumptionLabel = new Label(Long.toString(entry.getConsumption()));
        Label pressureToConsumeLabel = new Label(Integer.toString(entry.getPressureToConsume()));
        Label motivationLabel = new Label(Integer.toString(entry.getMotivation()));
        Label[] activitiesLabel = new Label[entry.getActivities().size()];
        for (int i = 0; i < entry.getActivities().size(); i++)
            activitiesLabel[i] = new Label(entry.getActivities().get(i).getActivity());
        Label commentLabel = new Label(entry.getComment());
        // Label questionForConsultationLabel = new Label(entry.getQuestionsForConsultation().getQuestion());

        vLayoutRight.add(dateLabel, consumptionLabel, pressureToConsumeLabel, motivationLabel);
        for(Label l : activitiesLabel)
            vLayoutRight.add(l);
        vLayoutRight.add(commentLabel);

        vLayoutLeft.setDefaultHorizontalComponentAlignment(Alignment.STRETCH);
        vLayoutRight.setDefaultHorizontalComponentAlignment(Alignment.STRETCH);

        vSplitLayout.addToPrimary(vLayoutLeft);
        vSplitLayout.addToSecondary(vLayoutRight);
        vSplitLayout.setOrientation(SplitLayout.Orientation.HORIZONTAL);
        vSplitLayout.addThemeVariants(SplitLayoutVariant.LUMO_MINIMAL);
        vSplitLayout.setPrimaryStyle("max-width", "30%");
        vSplitLayout.setPrimaryStyle("min-width", "10%");
        vSplitLayout.setWidthFull();

        vSplitLayout.addToPrimary(vLayoutLeft);
        vSplitLayout.addToSecondary(vLayoutRight);
        add(vSplitLayout);
    }
}
