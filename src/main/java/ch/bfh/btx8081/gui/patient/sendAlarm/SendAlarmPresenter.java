package ch.bfh.btx8081.gui.patient.sendAlarm;

import com.vaadin.flow.component.UI;

import ch.bfh.btx8081.gui.shared.main.MainView;
import ch.bfh.btx8081.interfaces.PatientService;

public class SendAlarmPresenter implements SendAlarmInterface.SendAlarmListener {
	
	
	private SendAlarmView view;
	PatientService service;
	private MainView main;

	public SendAlarmPresenter(SendAlarmView view, PatientService service, MainView main) {
		this.view = view;
		this.service = service;
		this.main = main;
		this.view.addListener(this);
	}
	

	@Override
	public void hadleBackClick() {
		main.openMainPatientView(service);
		
	}

	@Override
	public void hadleSendUrgentCaseAlarmClick(String message) {
		service.sendUrgentCaseAlarm(message);
		view.sentConfirmation("The doctor will contact you as soon as possible.");
	}

	@Override
	public void hadleSendAppontmentAlarmClick(String message) {
		service.sendAppontmentAlarm(message);
		view.sentConfirmation("You will get an appointment as soon as possible.");
	}

	@SuppressWarnings("deprecation")
	@Override
	public void hadleEmergencyAlarmclick() {
		// TODO Auto-generated method stub
		UI.getCurrent().getPage().executeJavaScript("window.open('tel:112');");
	}

}
