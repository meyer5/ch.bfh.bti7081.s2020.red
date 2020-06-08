package ch.bfh.btx8081.gui.doctor;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.notification.Notification;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.textfield.PasswordField;
import com.vaadin.flow.component.textfield.TextArea;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.dom.ElementFactory;
import com.vaadin.flow.router.Route;

@Route(value = "create-patient")
public class CreatePatientView extends VerticalLayout implements CreatePatientInterface {

	/**
	 * Form to create a patient
	 */

	private static final long serialVersionUID = 1L;

	private CreatePatientListener presenter;

	private FormLayout blockOne = new FormLayout();
	private FormLayout blockTwo = new FormLayout();
	private FormLayout blockThree = new FormLayout();
	private FormLayout blockFour = new FormLayout();
	private HorizontalLayout hLayout = new HorizontalLayout();

	private TextField firstName = new TextField();
	private TextField lastName = new TextField();
	private TextField phoneNumber = new TextField();
	private TextField eMail = new TextField();
	private TextField userName = new TextField();
	private PasswordField password = new PasswordField();
	private TextField addiction = new TextField();
	private TextField consumedSubstance = new TextField();
	private TextField consumptionMetric = new TextField();

	private TextArea mainInfo = new TextArea();

	public CreatePatientView() {

		Button saveButton = new Button("Save Patient", event -> {
			presenter.handleSaveClick(firstName.getValue(), lastName.getValue(), phoneNumber.getValue(),
					eMail.getValue(), userName.getValue(), password.getValue(), addiction.getValue(),
					mainInfo.getValue(), consumedSubstance.getValue(), consumptionMetric.getValue());
		});
		Button cancelButton = new Button("cancel", event -> {
			presenter.hadleCancelClick();
		});

		// blockOne
		firstName.setWidth("100%");
		blockOne.addFormItem(firstName, "First name");

		lastName.setWidth("100%");
		blockOne.addFormItem(lastName, "Last name");

		phoneNumber.setWidth("100%");
		blockOne.addFormItem(phoneNumber, "Phone number");

		eMail.setWidth("100%");
		blockOne.addFormItem(eMail, "Email");

		// blockTwo
		userName.setWidth("100%");
		blockTwo.addFormItem(userName, "Username");

		password.setWidth("100%");
		blockTwo.addFormItem(password, "Password");
		blockTwo.getElement().appendChild(ElementFactory.createBr());

		// block Three
		addiction.setWidth("100%");
		blockThree.addFormItem(addiction, "Addiction");

		consumedSubstance.setWidth("100%");
		blockThree.addFormItem(consumedSubstance, "Consumed substance");

		consumptionMetric.setWidth("100%");
		blockThree.addFormItem(consumptionMetric, "Consumed metric");

		// block four
		mainInfo.setWidth("100%");
		blockFour.addFormItem(mainInfo, "Main info");

		// add everything to layout

		hLayout.add(saveButton, cancelButton);

		add(new H2("Create new patient"), blockOne, blockTwo, blockThree, blockFour, hLayout);
	}

	@Override
	public void addListener(CreatePatientListener presenter) {
		this.presenter = presenter;
	}

	@Override
	public void userNameAlreadyTaken() {
		Notification.show("The username already exists");
	}

	@Override
	public void fillAllFields() {
		Notification.show("Please fill all the required fields");
	}

}
