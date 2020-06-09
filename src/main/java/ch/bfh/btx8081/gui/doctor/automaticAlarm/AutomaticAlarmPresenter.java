package ch.bfh.btx8081.gui.doctor.automaticAlarm;

import ch.bfh.btx8081.gui.shared.main.MainView;
import ch.bfh.btx8081.interfaces.DoctorService;
import ch.bfh.btx8081.model.Condition;

public class AutomaticAlarmPresenter implements AutomaticAlarmInterface.AutomaticAlarmListener {

	private AutomaticAlarmView view;
	private DoctorService service;
	private MainView main;
	
	public AutomaticAlarmPresenter(AutomaticAlarmView view, DoctorService service, MainView main) {
		this.view = view;
		this.service = service;
		this.main = main;
		this.view.addListener(this);
		this.view.setCondition(service.getPatient().getDiary().getConditionAutomaticAlarm());
	}
	
	@Override
	public void handleSetConditionClick(Condition condition) {
		service.setConditionAutomaticAlarm(condition);
		view.showSavedNotification();
		this.view.setCondition(service.getPatient().getDiary().getConditionAutomaticAlarm());
	}

	@Override
	public void handleDeleteConditionClick() {
		service.removeConditionAutomaticAlarm();
		view.showSavedNotification();
		this.view.setCondition(service.getPatient().getDiary().getConditionAutomaticAlarm());
	}

	@Override
	public void hadleBackClick() {
		main.openPatientInfoView(service);
	}
	
}
