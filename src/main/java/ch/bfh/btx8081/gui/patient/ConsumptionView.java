package ch.bfh.btx8081.gui.patient;

import java.math.BigDecimal;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.BigDecimalField;
import com.vaadin.flow.component.textfield.TextFieldVariant;

public class ConsumptionView extends VerticalLayout implements PatientViewInterface {

	/**
	 * View where patient can enter his daily consumption
	 */
	private static final long serialVersionUID = -8273399642497118085L;

	public static final String VIEW_NAME = "Consumption";

	private Presenter presenter;
	private EntryViewController viewController;
	
	private Label motivationLbl;
	private BigDecimalField bigDecimalField;
	private Button nextBtn;

	public ConsumptionView(Presenter presenter, EntryViewController viewController) {
		
		this.presenter = presenter;
		this.viewController = viewController;
		
		// Label with instruction
		motivationLbl = new Label("How much have you consumed today?");
		this.add(motivationLbl);

		bigDecimalField = new BigDecimalField("Total consumption");
		bigDecimalField.addThemeVariants(TextFieldVariant.LUMO_ALIGN_RIGHT);
		// TODO link wit ConsumtionMetric from DiaryManager
		// setPrefixComponent(new Icon(VaadinIcon.DOLLAR));
		this.add(bigDecimalField);
		
		// Next Button
		nextBtn = new Button("Next");
		// go to next view
		nextBtn.addClickListener(e -> handleNextBtn());
		// pass value to listener
		
		this.add(nextBtn);

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
		presenter.nextBtnClicked(ConsumptionView.VIEW_NAME, getConsumption());
	}

}
