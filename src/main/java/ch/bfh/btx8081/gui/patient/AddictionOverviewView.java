package ch.bfh.btx8081.gui.patient;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

import java.time.LocalDate;

public class AddictionOverviewView extends VerticalLayout implements PatientViewInterface
{
    public static final String VIEW_NAME = "AddictionView";
    private Presenter presenter;
    private EntryViewController viewController;

    private Label title;
    private Button nextBtn;
    private DatePicker readonlyDatePicker;

    public AddictionOverviewView(Presenter presenter, EntryViewController viewController)
    {
        this.presenter = presenter;
        this.viewController = viewController;

        this.title = new Label("Addiction Overview");
        add(title);
        // Show date for entry
        this.readonlyDatePicker = new DatePicker();
        readonlyDatePicker.setLabel("Read-only");
        readonlyDatePicker.setValue(LocalDate.now());
        readonlyDatePicker.setReadOnly(true);
        add(readonlyDatePicker);

    }

    private LocalDate getEntryDate() {
        return readonlyDatePicker.getValue();
    }

    @Override
    public void handleNextBtn()
    {
        this.viewController.setView();
        presenter.nextBtnClicked(ActivityView.VIEW_NAME, getEntryDate());
    }

    @Override
    public String getName() {
        return AddictionOverviewView.VIEW_NAME;
    }
}
