package ch.bfh.btx8081.gui.doctor.automaticAlarm;

import ch.bfh.btx8081.model.Condition;

public interface AutomaticAlarmInterface {
	
	public void addListener(AutomaticAlarmListener presenter);
	
	public void setCondition(Condition condition);
	
	public void showSavedNotification();
	
	public interface AutomaticAlarmListener {
		
		public void handleSetConditionClick(Condition condition);
		
		public void handleDeleteConditionClick();
		
		public void hadleBackClick();
		
	}

}
