package interfaces;

import exceptions.UserNotFoundException;
import exceptions.WrongPasswordException;
import model.DiaryManager;
import model.Doctor;
import model.Patient;

public abstract class ServiceManager {
	
	static private DiaryManager diaryManager = DiaryManager.getInstance();
//	private static ServiceManager instance;
//	
//	private ServiceManager() {
//	}
//	
//	public static ServiceManager getInstance() {
//		if (instance == null) {
//            instance = new ServiceManager();
//        }
//        return instance;
//	}
	
	public static Service  getService(String userName, String Password) throws WrongPasswordException, UserNotFoundException {
		diaryManager.authenticate(userName, Password);
		
		if (diaryManager.searchUserByUsername(userName).getClass().equals(Doctor.class)) {
			return (Service) new DoctorService((Doctor) diaryManager.searchUserByUsername(userName));
			
		} if (diaryManager.searchUserByUsername(userName).getClass().equals(Patient.class)) {
			return (Service) new PatientService((Patient) diaryManager.searchUserByUsername(userName));	
		} else {
			return null;
		}
		
	}
	

}
