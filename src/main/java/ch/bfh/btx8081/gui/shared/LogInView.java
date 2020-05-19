package ch.bfh.btx8081.gui.shared;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

import ch.bfh.btx8081.exceptions.UserNotFoundException;
import ch.bfh.btx8081.exceptions.WrongPasswordException;
import ch.bfh.btx8081.gui.doctor.DoctorPresenter;
import ch.bfh.btx8081.gui.patient.PatientPresenter;
import ch.bfh.btx8081.interfaces.DoctorService;
import ch.bfh.btx8081.interfaces.PatientService;
import ch.bfh.btx8081.interfaces.Service;
import ch.bfh.btx8081.interfaces.ServiceManager;

/**
 * The main view contains a button and a click listener.
 */
@Route("login")
@PWA(name = "Project Base for Vaadin", shortName = "Project Base")
public class LogInView extends VerticalLayout {

	private static final long serialVersionUID = 1L;
	private Label userNameLbl = new Label("User Name:");
	private TextField userName = new TextField();
	private Label passwordLbl = new Label("Password:");
	private PasswordField password = new PasswordField();

	public LogInView() {

		Button button = new Button("Log in", event -> {
			try {
				Service service = ServiceManager.getService(userName.getValue(), password.getValue());
				if (service instanceof DoctorService) {
					new DoctorPresenter((DoctorService) service, this.getUI());
				} else if (service instanceof PatientService) {
					new PatientPresenter((PatientService) service, this.getUI());
				}
			} catch (WrongPasswordException | UserNotFoundException e) {
				Notification.show("Username or password wrong!");
				System.out.println(userName.getValue() + " - " + password.getValue());
				e.printStackTrace();
			}
		});
		add(userNameLbl);
		add(userName);
		add(passwordLbl);
		add(password);
		add(button);
	}
}
