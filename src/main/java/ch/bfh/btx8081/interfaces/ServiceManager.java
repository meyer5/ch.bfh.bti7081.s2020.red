package ch.bfh.btx8081.interfaces;

import ch.bfh.btx8081.exceptions.UserNotFoundException;
import ch.bfh.btx8081.exceptions.WrongPasswordException;
import ch.bfh.btx8081.model.DiaryManager;
import ch.bfh.btx8081.model.Doctor;
import ch.bfh.btx8081.model.Patient;
import ch.bfh.btx8081.model.User;

public abstract class ServiceManager {
	
	private static DiaryManager diaryManager = DiaryManager.getInstance();
	
	public static Service  getService(String userName, String Password) throws WrongPasswordException, UserNotFoundException {
		User user = diaryManager.authenticate(userName, Password);
		
		if (user.getClass().equals(Doctor.class)) {
			return (Service) new DoctorService((Doctor) user);
			
		} if (user.getClass().equals(Patient.class)) {
			return (Service) new PatientService((Patient) user);
		} else {
			return null;
		}
		
	}
	
}
