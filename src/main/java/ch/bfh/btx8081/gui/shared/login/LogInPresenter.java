package ch.bfh.btx8081.gui.shared.login;

import ch.bfh.btx8081.exceptions.UserNotFoundException;
import ch.bfh.btx8081.exceptions.WrongPasswordException;
import ch.bfh.btx8081.gui.shared.main.MainView;
import ch.bfh.btx8081.interfaces.DoctorService;
import ch.bfh.btx8081.interfaces.PatientService;
import ch.bfh.btx8081.interfaces.Service;
import ch.bfh.btx8081.interfaces.ServiceManager;

public class LogInPresenter implements LogInInterface.LogInViewListener {

	private LogInView view;
	private MainView main;

	public LogInPresenter(LogInView view, MainView main) {
		this.view = view;
		this.main = main;
		view.addListener(this);
	}

	@Override
	public void handleLogiInClick(String userName, String password) {
		try {
			Service service = ServiceManager.getService(userName, password);
			if (service instanceof DoctorService) {
				main.openMainDoctorView((DoctorService) service);
			} else if (service instanceof PatientService) {
				main.openMainPatientView((PatientService) service);
			}
		} catch (WrongPasswordException | UserNotFoundException e) {
			view.showNotification("Username or password wrong!");
			System.out.println(userName + " - " + password);
			e.printStackTrace();
		}

	}

}
