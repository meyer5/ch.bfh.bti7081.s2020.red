package ch.bfh.btx8081.gui.patient.sendAlarm;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.router.Route;


@Route(value = "send-alarm")
public class SendAlarmView extends VerticalLayout implements SendAlarmInterface {

	private static final long serialVersionUID = 1L;
	public static final String TITLE = "SendAlarmView";
	
	private SendAlarmListener presenter;
	
	private TextArea message = new TextArea("");
	
	public SendAlarmView() {
		
		Button emergencyButton = new Button("Emergency", event -> {
			presenter.hadleEmergencyAlarmclick();
		});
		
		Button urgentCaseButton = new Button("I have an urgent case", event -> {
			presenter.hadleSendUrgentCaseAlarmClick(message.getValue());
		});
		
		Button appointmentButton = new Button("I need an appointment", event -> {
			presenter.hadleSendAppontmentAlarmClick(message.getValue());
		});
		
		Button backButton = new Button("Back", event -> {
			presenter.hadleBackClick();
		});
		
		add(message, emergencyButton, urgentCaseButton, appointmentButton, backButton);
	}
	

	@Override
	public void addListener(SendAlarmListener presenter) {
		this.presenter = presenter;
	}


	@Override
	public void sentConfirmation(String message) {
		this.message.setValue("");
		Notification.show(message);
		
	}

}
