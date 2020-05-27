package ch.bfh.btx8081.gui.patient.newEntry;

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
public class NewEntryConsumptionView extends VerticalLayout implements NewEntryInterface {

private static final long serialVersionUID = 1L;
	
	private NewEntryListener presenter;
	
	private Label title;
	private Label motivationLbl;
	private BigDecimalField bigDecimalField;
	private Button nextBtn;

	public NewEntryConsumptionView() {
		
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
		nextBtn.addClickListener(e -> {
			presenter.handleConfirmConsumption(bigDecimalField.getValue().longValue());
		});
		add(nextBtn);
	}
	
	@Override
	public void setListener(NewEntryListener presenter) {
		this.presenter = presenter;
	}

}
