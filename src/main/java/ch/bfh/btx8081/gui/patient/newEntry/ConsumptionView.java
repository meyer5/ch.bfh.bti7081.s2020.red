package ch.bfh.btx8081.gui.patient.newEntry;

import java.math.BigDecimal;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.BigDecimalField;
import com.vaadin.flow.component.textfield.TextFieldVariant;
import com.vaadin.flow.router.Route;

/**
 * View where patient can enter his daily consumption
 * 
 * @author Remo
 *
 */
@Route(value="entry-consumption")
public class ConsumptionView extends VerticalLayout implements PatientViewInterface {

	private static final long serialVersionUID = -8273399642497118085L;

	public static final String VIEW_NAME = "Consumption";

	private NewEntryPresenter patientPresenter;
	private EntryViewController viewController;
	
	private Label title;
	private Label motivationLbl;
	private BigDecimalField bigDecimalField;
	private Button nextBtn;

	public ConsumptionView(NewEntryPresenter patientPresenter, EntryViewController viewController) {
		
		this.patientPresenter = patientPresenter;
		this.viewController = viewController;
		
		// Label with title
		this.title = new Label("Consumption");
		add(title);
		
		// Label with instruction
		motivationLbl = new Label("How much have you consumed today?");
		add(motivationLbl);

		bigDecimalField = new BigDecimalField("Total consumption");
		bigDecimalField.addThemeVariants(TextFieldVariant.LUMO_ALIGN_RIGHT);
		// TODO link wit ConsumtionMetric from DiaryManager
		// setPrefixComponent(new Icon(VaadinIcon.DOLLAR));
		add(bigDecimalField);
		
		nextBtn = new Button("Next");
		nextBtn.addClickListener(e -> handleNextBtn());
		add(nextBtn);

	}

	public BigDecimal getConsumption() {
		return bigDecimalField.getValue();
	}

	@Override
	public String getName() {
		return ConsumptionView.VIEW_NAME;
	}

	@Override
	public void handleNextBtn() {
		this.viewController.setView();
		patientPresenter.nextBtnClicked(ConsumptionView.VIEW_NAME, getConsumption());
	}

}
