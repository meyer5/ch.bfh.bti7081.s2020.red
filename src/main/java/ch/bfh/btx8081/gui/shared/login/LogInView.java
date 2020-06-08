package ch.bfh.btx8081.gui.shared.login;

import java.util.ArrayList;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.server.PWA;

/**
 * The main view contains a button and a click listener.
 */
@Route("login")
@PWA(name = "Project Base for Vaadin", shortName = "Project Base")
@CssImport("styles/shared-styles.css")
public class LogInView extends VerticalLayout implements LogInInterface {

	private static final long serialVersionUID = 1L;

	private ArrayList<LogInViewListener> listeners = new ArrayList<LogInViewListener>();

	private Label userNameLbl = new Label("User Name:");
	private TextField userName = new TextField();
	private Label passwordLbl = new Label("Password:");
	private PasswordField password = new PasswordField();

	public LogInView() {

		Button button = new Button("Log in", event -> {
			listeners.forEach(listener -> listener.handleLogiInClick(userName.getValue(), password.getValue()));
		});
		button.addThemeVariants(ButtonVariant.LUMO_PRIMARY);
		add(userNameLbl);
		add(userName);
		add(passwordLbl);
		add(password);
		add(button);
	}

	@Override
	public void addListener(LogInViewListener listener) {
		listeners.add(listener);
	}

	@Override
	public void showNotification(String message) {
		Notification.show(message);
	}

}
