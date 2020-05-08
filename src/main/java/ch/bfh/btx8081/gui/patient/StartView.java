package ch.bfh.btx8081.gui.patient;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

@Route(value = "start")
public class StartView extends VerticalLayout implements PatientViewInterface {

	/**
	 * UNUSED
	 */
	private static final long serialVersionUID = 418949200607167402L;

	public static final String VIEW_NAME = "Start View";

	private Button entryBtn;
	private Button alarmBtn;
	private Button createActivityBtn;

	public StartView() {
		createButtons();
	}

	private VerticalLayout createButtons() {
		VerticalLayout buttons = new VerticalLayout();
		entryBtn = new Button("Diary Entry");
		// entryBtn.addClickListener(e -> );
		buttons.add(entryBtn);

		alarmBtn = new Button("Alarm");
		// alarmBtn.addClickListener(e -> );
		buttons.add(alarmBtn);

		createActivityBtn = new Button("Create Activity");
		// createActivityBtn.addClickListener(e -> );
		buttons.add(createActivityBtn);

		return buttons;
	}

	@Override
	public void addListener(ViewListenerInterface listener) {
		// TODO Auto-generated method stub
		
	}

}
