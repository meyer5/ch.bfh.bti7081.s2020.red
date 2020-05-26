package ch.bfh.btx8081.gui.patient;

import ch.bfh.btx8081.model.Entry;
import ch.bfh.btx8081.model.Patient;

public interface MainPatientInterface {
	
	public void setPatient(Patient patient);
	
	public void setPresenter(MainPatientListener presenter);
	
	public void showAvoidanceSrategy(String strategy);
	
	public interface MainPatientListener {
		
		public void handleNewEntryClick();
		
		public void hadleActivitiesClick();
		
		public void hadleStrategiesClick();
		
		public void hadleQuestionsClick();
		
		public void hadleShowStrategyClick();
		
		public void hadleAlarmClick();
		
		public void hadleOpenEntryClick(Entry entry);
		
		public void hadleEntriesListClick();
		
		public void hadleLogOutClick();
		
	}

}
