package ch.bfh.btx8081.gui.shared;

import ch.bfh.btx8081.model.Activity;
import ch.bfh.btx8081.model.Patient;

public interface ActivitiesInterface {
	
	public void setPatient(Patient patient);

	public void addListener(ActivitiesListener presenter);

	public interface ActivitiesListener {

		public void hadleBackClick();
		
		public void hadleDeleteActivityClick(Activity activity);
		
		public void hadleSaveClick(String activity, String iconID);

	}

}
