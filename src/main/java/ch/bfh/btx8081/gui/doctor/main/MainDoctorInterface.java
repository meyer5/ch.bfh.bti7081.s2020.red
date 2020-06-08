package ch.bfh.btx8081.gui.doctor.main;

import java.util.List;

import ch.bfh.btx8081.model.Alarm;
import ch.bfh.btx8081.model.Patient;

public interface MainDoctorInterface {
	
	public void setPatientList(List<Patient> patients);

	public void addListener(MainDoctorListener presenter);
	
	public void setAlarms(List<Alarm> alarms);

	public interface MainDoctorListener {

		public void hadleCreateNewPatientClick();

		public void hadleOpenPatientClick(Patient patient);
		
		public void hadleSearchPatientClick(String search);
		
		public void hadleLogOutClick();
		
		public void handleAlarmDoneClick(Alarm alarm);

	}

}
