package ch.bfh.btx8081.gui.doctor.automaticAlarm;

import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;

import ch.bfh.btx8081.model.Condition;

@Route(value = "condition-automatic-alarm")
public class AutomaticAlarmView extends VerticalLayout implements AutomaticAlarmInterface {

	private static final long serialVersionUID = 1L;
	public static final String TITLE = "ConditionAtomaticAlarm";
	
	private AutomaticAlarmListener presenter;
	
	@Override
	public void setAlarm(Condition condition) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addListener(AutomaticAlarmListener presenter) {
		this.presenter = presenter;

	}

	@Override
	public void showSavedNotification() {
		Notification.show("Saved.");
	}

}
