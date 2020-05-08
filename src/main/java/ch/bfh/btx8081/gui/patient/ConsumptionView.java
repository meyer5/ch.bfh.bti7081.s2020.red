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

	private ViewListenerInterface presenter;

	private Label motivationLbl;
	private BigDecimalField bigDecimalField;
	private Button nextBtn;

	public ConsumptionView(NewEntryView baseView) {
		
		presenter = new Presenter();
		
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
		nextBtn.addClickListener(e -> baseView.setView(baseView.getCommentView()));
		// pass value to listener
		presenter.nextBtnClicked(this.VIEW_NAME, getConsumption());
		this.add(nextBtn);

	}

	public BigDecimal getConsumption() {
		return bigDecimalField.getValue();
	}

	@Override
	public void addListener(ViewListenerInterface listener) {
		this.presenter = listener;

	}

}
