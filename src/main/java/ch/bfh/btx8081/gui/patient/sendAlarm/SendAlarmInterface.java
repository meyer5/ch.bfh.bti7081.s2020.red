package ch.bfh.btx8081.gui.patient.sendAlarm;

public interface SendAlarmInterface {
	
	public void addListener(SendAlarmListener presenter);
	
	public void sentConfirmation(String message);
	
	public interface SendAlarmListener {
		
		public void hadleBackClick();
		
		public void hadleSendUrgentCaseAlarmClick(String message);
		
		public void hadleSendAppontmentAlarmClick(String message);
		
		public void hadleEmergencyAlarmclick();
		
	}

}
