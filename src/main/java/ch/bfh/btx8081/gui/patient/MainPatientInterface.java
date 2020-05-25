package ch.bfh.btx8081.gui.patient;

public interface MainPatientInterface {
	
	public void setPatient();
	
	public void addListener(MainPatientListener presenter);
	
	public interface MainPatientListener {
		
		public void handleNewEntryClick();
		
		public void hadleActivitiesClick();
		
		public void hadleStrategiesClick();
		
		public void hadleQuestionsClick();
		
		public void hadleShowStrategyClick();
		
		public void hadleAlarmClick();
		
		public void hadleOpenEntryClick();
		
		public void hadleEntriesListClick();
		
	}

}
